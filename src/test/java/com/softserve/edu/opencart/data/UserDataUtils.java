package com.softserve.edu.opencart.data;

import java.util.ArrayList;
import java.util.List;

import com.softserve.edu.opencart.tools.IExternalData;

public final class UserDataUtils {
	private String path;
	private IExternalData externalData;

	public UserDataUtils(String path, IExternalData externalData) {
		this.path = path;
		this.externalData = externalData;
	}

	public List<IUser> getAllUsers() {
		//System.out.println("+++ Path to file: "
		//		+ this.getClass().getResource(path).getPath());
		return getAllUsers(this.getClass()
				.getResource(path).getPath().substring(1));
	}

	public List<IUser> getAllUsers(String connection) {
		List<IUser> users = new ArrayList<IUser>();
		List<String> rowModify;
		for (List<String> row : externalData.getAllCells(connection)) {
			if (row.get(2).toLowerCase().equals("email")
					&& row.get(3).toLowerCase().equals("telephone")) {
				continue;
			}
			rowModify = new ArrayList<String>(row);
			for (int i = row.size(); i < 14; i++) {
				rowModify.add(i, new String());
			}
			//System.out.println("\t+++new User: EMail= " + rowModify.get(2)
			//	+ "  Fax= " + rowModify.get(10));
			//	+ "  Fax= " + (rowModify.get(10) == null ? new String() : rowModify.get(10)));
			// TODO Use Builder.
			users.add(User.get()
					.setFirstname(row.get(0))
					.setLastname(row.get(1))
					.setEmail(row.get(2))
					.setTelephone(row.get(3))
					.setAddress(row.get(4))
					.setCity(row.get(5))
					.setPostcode(row.get(6))
					.setCountry(row.get(7))
					.setRegionState(row.get(8))
					.setPassword(row.get(9))
					.setFax(rowModify.get(10))
					.setCompany(rowModify.get(11))
					.setSecondAddress(rowModify.get(12))
					.setNewsletter(rowModify.get(13))
					.build());
		}
		return users;
	}

}
