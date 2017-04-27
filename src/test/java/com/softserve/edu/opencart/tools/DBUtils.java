package com.softserve.edu.opencart.tools;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DBUtils implements IExternalData {
	private static final String FOUND_SQL_EXCEPTION = "SQL Exception found";
	private static final String LOGIN_FROM_ENVIRONMENT = "login";
	private static final String PASSWORD_FROM_ENVIRONMENT = "password";
	//
	// TODO This is hardcode. Must be refactor
	private String login = "root";
	private String password = "root";
	private String url = "jdbc:mysql://localhost:3306/lv223test";

	public DBUtils(String url, String login, String password) {
		this.url = url;
		this.login = login;
		this.password = password;
	}

	public DBUtils(String url) {
		this.url = url;
		initCredentional();
	}

	private void initCredentional() {
		login = System.getenv(LOGIN_FROM_ENVIRONMENT);
		password = System.getenv(PASSWORD_FROM_ENVIRONMENT);
	}

	public List<List<String>> getAllCells(String connection) {
		List<List<String>> allCells = new ArrayList<List<String>>();
		List<String> rowCells = null;
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		int columnCount = 0;
		//
		try {
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			// DriverManager.registerDriver(new
			// com.microsoft.sqlserver.jdbc.SQLServerDriver());
			//DriverManager.registerDriver(new net.sourceforge.jtds.jdbc.Driver());
			con = DriverManager.getConnection(url, login, password);
		} catch (Exception e) {
			throw new RuntimeException(FOUND_SQL_EXCEPTION, e);
		}
		// TODO Delete messages
		if (con != null) {
			System.out.println("+++Connection Successful! \n");
		} else {
			System.out.println("+++Connection fail \n");
			System.exit(0);
		}
		try {
			st = con.createStatement();
			//rs = st.executeQuery("select firstname, lastname, email, password from users;");
			rs = st.executeQuery(connection);
			columnCount = rs.getMetaData().getColumnCount();
			//
			while (rs.next()) {
				rowCells = new ArrayList<String>();
				for (int i = 1; i <= columnCount; i++) {
					rowCells.add(rs.getString(i));
					System.out.print("+++\t" + rs.getString(i) + "\t");
				}
				allCells.add(rowCells);
				System.out.println();
			}
			if (rs != null) {
				rs.close();
			}
			if (st != null) {
				st.close();
			}
			if (con != null) {
				con.close();
			}
		} catch (Exception e) {
			throw new RuntimeException(FOUND_SQL_EXCEPTION, e);
		}
		return allCells;
	}

}
