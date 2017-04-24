package com.softserve.edu.opencart.data;

import java.util.List;

import com.softserve.edu.opencart.tools.CSVUtils;
import com.softserve.edu.opencart.tools.DBUtils;
import com.softserve.edu.opencart.tools.ExcelUtils;

public final class UserRepository {
	
	// For Singleton.
	private static volatile UserRepository instance;

	// For Singleton.
	private UserRepository() {
	}

	// For Singleton.
	public static UserRepository get() {
		if (instance == null) {
			synchronized (UserRepository.class) {
				if (instance == null) {
					instance = new UserRepository();
				}
			}
		}
		return instance;
	}

	public IUser getJohnDoeUser() {
		return User.get()
			.setFirstname("firstname")
			.setLastname("lastname")
			.setEmail("JohnDoe7@gmail.com")
			.setTelephone("telephone")
			.setAddress("ee")
			.setCity("ff")
			.setPostcode("gg")
			.setCountry("hh")
			.setRegionState("ii")
			.setPassword("qwerty1234")
			.setFax("fax")
			.setCompany("company")
			.setSecondAddress("secondAddress")
			.setNewsletter("newsletter")
			.build();
	}

	public IUser getNewUser() {
		return User.get()
			.setFirstname("bob")
			.setLastname("bob")
			.setEmail("bob8@gmail.com")
			.setTelephone("380321234567")
			.setAddress("Pasternaka")
			.setCity("L'viv")
			.setPostcode("79000")
			.setCountry("Ukraine")
			.setRegionState("L'vivs'ka Oblast'")
			.setPassword("qwerty1234")
			.setFax("fax")
			.setCompany("company")
			.setSecondAddress("secondAddress")
			.setNewsletter("newsletter")
			.build();
	}

	public static List<IUser> getUsersFromCsvFile() {
		return new UserDataUtils("/existUsers.csv", new CSVUtils()).getAllUsers();
	}

	public static List<IUser> getUsersFromCsvFile(String filename) {
		return new UserDataUtils(filename, new CSVUtils()).getAllUsers();
	}

	public static List<IUser> getUsersFromExcelFile() {
		return new UserDataUtils("/existUsers.xlsx", new ExcelUtils()).getAllUsers();
	}

	public static List<IUser> getUsersFromExcelFile(String filename) {
		return new UserDataUtils(filename, new ExcelUtils()).getAllUsers();
	}

	public static List<IUser> getUsersFromDB() {
		return new UserDataUtils("select firstname, lastname, email, '', '', '', '', '', '', password from users;",
				new DBUtils("jdbc:mysql://localhost:3306/lv223test",
						"root", "root")).getAllDBUsers();
	}

	public static List<IUser> getUsersFromLocalDB() {
		return new UserDataUtils("select firstname, lastname, email, '', '', '', '', '', '', password from users;",
				new DBUtils("jdbc:mysql://localhost:3306/lv223test")).getAllDBUsers();
	}

	public static List<IUser> getUsersFromDB(String sqlQuery) {
		return new UserDataUtils(sqlQuery,
				new DBUtils("jdbc:mysql://localhost:3306/lv223test",
						"root", "root")).getAllDBUsers();
	}

}
