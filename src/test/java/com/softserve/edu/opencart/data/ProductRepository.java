package com.softserve.edu.opencart.data;

import java.util.ArrayList;
import java.util.List;

public final class ProductRepository {

	private ProductRepository() {
	}
	
	public static Product getDesktopIMac() {
		return new Product("iMac",
				"Just when you thought iMac had everything, now there´s even more. More powerful Intel Core 2 Duo ..",
				"99.78", "81.79");
	}

	public static List<Product> getDesktopIMacs() {
		List<Product> products = new ArrayList<Product>();
		products.add(new Product("iMac",
				"Just when you thought iMac had everything, now there´s even more. More powerful Intel Core 2 Duo ..",
				"99.78", "81.79"));
		products.add(new Product("iMac",
				"Just when you thought iMac had everything, now there´s even more. More powerful Intel Core 2 Duo ..",
				"99.78", "81.79"));
		return products;
	}

	public static List<Product> getLaptopHPs() {
		List<Product> products = new ArrayList<Product>();
		products.add(new Product("HP LP3065",
				"Stop your co-workers in their tracks with the stunning new 30-inch diagonal HP LP3065 Flat Panel ..",
				"99.78", "81.79"));
		products.add(new Product("HP 250 G5",
				"Take your work with you and quickly get the job done without stress or waiting around with the speed..",
				"408.93", "408.93"));
		products.add(new Product("HP Pavilion x360",
				"A1 are open boxed units which have been returned usually due to been unwanted. The units may have at..",
				"433.46", "433.46"));
		return products;
	}

//	public static List<Product> getProductFromCsvFile() {
//		return new ProductUtils().getAllProduct();
//	}
//
//	public static List<Product> getProductFromExcelFile() {
//		return new ProductUtils("/newUsers.xlsx", new ExcelUtils()).getAllProduct();
//	}
//
//	public static List<Product> getProductFromDB() {
//		return new ProductUtils("/", new DBUtils()).getAllProduct();
//	}

}
