package com.softserve.edu.opencart.data;

interface IFirstname {
	ILastname setFirstname(String firstname);
}

interface ILastname {
	IEmail setLastname(String lastname);
}

interface IEmail {
	ITelephone setEmail(String email);
}

interface ITelephone {
	IAddress setTelephone(String telephone);
}

interface IAddress {
	ICity setAddress(String address);
}

interface ICity {
	IPostcode setCity(String city);
}

interface IPostcode {
	ICountry setPostcode(String postcode);
}

interface ICountry {
	IRegionState setCountry(String country);
}

interface IRegionState {
	IPassword setRegionState(String regionState);
}

interface IPassword {
	IUserAdditional setPassword(String password);
}

interface IBuildUser {
	IUser build();
}

interface IUserAdditional extends IBuildUser {

	IUserAdditional setFax(String fax);

	IUserAdditional setCompany(String company);

	IUserAdditional setSecondAddress(String secondAddress);

	IUserAdditional setNewsletter(String newsletter);
}

class User implements IFirstname, ILastname, IEmail,
		ITelephone, IAddress, ICity, IPostcode, ICountry,
		IRegionState, IPassword, IUserAdditional, IUser {

	private String firstname;
	private String lastname;
	private String email;
	private String telephone;
	private String address;
	private String city;
	private String postcode;
	private String country;
	private String regionState;
	private String password;
	//
	private String fax;
	private String company;
	private String secondAddress;
	private String newsletter;

	// 1. Too many paremeters. Bad Solution.
	// public User(String firstname, String lastname, String email, String
	// telephone, String address, String city,
	// String postcode, String country, String regionState, String password,
	// String fax, String company,
	// String secondAddress, String newsletter) {
	// this.firstname = firstname;
	// this.lastname = lastname;
	// this.email = email;
	// this.telephone = telephone;
	// this.address = address;
	// this.city = city;
	// this.postcode = postcode;
	// this.country = country;
	// this.regionState = regionState;
	// this.password = password;
	// this.fax = fax;
	// this.company = company;
	// this.secondAddress = secondAddress;
	// this.newsletter = newsletter;
	// }

	// 2. Use setters.
	// public User() {
	// }

	// 4. Use Static Factory.
	private User() {
		fax = new String();
		company = new String();
		secondAddress = new String();
		newsletter = new String();
	}

	public static IFirstname get() {
		return new User();
	}

	// setters

	public ILastname setFirstname(String firstname) {
		this.firstname = firstname;
		return this;
	}

	public IEmail setLastname(String lastname) {
		this.lastname = lastname;
		return this;
	}

	public ITelephone setEmail(String email) {
		this.email = email;
		return this;
	}

	public IAddress setTelephone(String telephone) {
		this.telephone = telephone;
		return this;
	}

	public ICity setAddress(String address) {
		this.address = address;
		return this;
	}

	public IPostcode setCity(String city) {
		this.city = city;
		return this;
	}

	public ICountry setPostcode(String postcode) {
		this.postcode = postcode;
		return this;
	}

	public IRegionState setCountry(String country) {
		this.country = country;
		return this;
	}

	public IPassword setRegionState(String regionState) {
		this.regionState = regionState;
		return this;
	}

	public IUserAdditional setPassword(String password) {
		this.password = password;
		return this;
	}

	public IUser build(){
		return this;
	}
	
	// TODO
	
	public IUserAdditional setFax(String fax) {
		this.fax = fax;
		return this;
	}

	public IUserAdditional setCompany(String company) {
		this.company = company;
		return this;
	}

	public IUserAdditional setSecondAddress(String secondAddress) {
		this.secondAddress = secondAddress;
		return this;
	}

	public IUserAdditional setNewsletter(String newsletter) {
		this.newsletter = newsletter;
		return this;
	}

	// getters

	public String getFirstname() {
		return firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public String getEmail() {
		return email;
	}

	public String getTelephone() {
		return telephone;
	}

	public String getAddress() {
		return address;
	}

	public String getCity() {
		return city;
	}

	public String getPostcode() {
		return postcode;
	}

	public String getCountry() {
		return country;
	}

	public String getRegionState() {
		return regionState;
	}

	public String getPassword() {
		return password;
	}

	public String getFax() {
		return fax;
	}

	public String getCompany() {
		return company;
	}

	public String getSecondAddress() {
		return secondAddress;
	}

	public String getNewsletter() {
		return newsletter;
	}

}
