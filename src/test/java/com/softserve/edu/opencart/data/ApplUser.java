package com.softserve.edu.opencart.data;

public class ApplUser {

	public static void main(String[] args) {
		//
		// 1. Use Constructor. Too many paremeters. Bad Solution.
		//User user = new User("aa", "bb", "cc", "dd", "ee", "ff", "gg", "hh", "ii", "jj", "kk", "ll", "mm", "nn");
		//
		// 2. Use Setters.
//		User user = new User();
//		user.setFirstname("aa");
//		user.setLastname("bb");
//		user.setEmail("cc");
//		user.setTelephone("dd");
//		user.setAddress("ee");
//		user.setCity("ff");
//		user.setPostcode("gg");
//		user.setCountry("hh");
//		user.setRegionState("ii");
//		user.setPassword("jj");
//		user.setFax("kk");
//		user.setCompany("ll");
//		user.setSecondAddress("mm");
//		user.setNewsletter("nn");
		//
		// 3. Add Fluent Interface.
//		User user = new User()
//				.setFirstname("aa")
//				.setLastname("bb")
//				.setEmail("cc")
//				.setTelephone("dd")
//				.setAddress("ee")
//				.setCity("ff")
//				.setPostcode("gg")
//				.setCountry("hh")
//				.setRegionState("ii")
//				.setPassword("jj")
//				.setFax("kk")
//				.setCompany("ll")
//				.setSecondAddress("mm")
//				.setNewsletter("nn");
		//
		// 4. Add Static Factory.
//		User user = User.get()
//				.setFirstname("aa")
//				.setLastname("bb")
//				.setEmail("cc")
//				.setTelephone("dd")
//				.setAddress("ee")
//				.setCity("ff")
//				.setPostcode("gg")
//				.setCountry("hh")
//				.setRegionState("ii")
//				.setPassword("jj")
//				.setFax("kk")
//				.setCompany("ll")
//				.setSecondAddress("mm")
//				.setNewsletter("nn");
		//
		// 5. Add Builder.
//		User user = User.get()
//				.setFirstname("firstname")
//				.setLastname("lastname")
//				.setEmail("email")
//				.setTelephone("telephone")
//				.setAddress("ee")
//				.setCity("ff")
//				.setPostcode("gg")
//				.setCountry("hh")
//				.setRegionState("ii")
//				.setPassword("jj")
//				.build();
//		System.out.println("login = " + user.setEmail("1111"));
		//
		// 6. Add Dependency Inversion.
//		IUser user = User.get()
//				.setFirstname("firstname")
//				.setLastname("lastname")
//				.setEmail("email")
//				.setTelephone("telephone")
//				.setAddress("ee")
//				.setCity("ff")
//				.setPostcode("gg")
//				.setCountry("hh")
//				.setRegionState("ii")
//				.setPassword("jj")
//				.build();
//		//System.out.println("login = " + user.setEmail("1111"));
		//
		// 7. Add Unnecessary Fields.
		IUser user = User.get()
				.setFirstname("firstname")
				.setLastname("lastname")
				.setEmail("email")
				.setTelephone("telephone")
				.setAddress("ee")
				.setCity("ff")
				.setPostcode("gg")
				.setCountry("hh")
				.setRegionState("ii")
				.setPassword("jj")
				.setFax("fax")
				.setCompany("company")
				.setSecondAddress("secondAddress")
				.setNewsletter("newsletter")
				.build();
		//
		System.out.println("login = " + user.getEmail());
	}

}
