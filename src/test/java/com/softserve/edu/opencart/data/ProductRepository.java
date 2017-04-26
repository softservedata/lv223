package com.softserve.edu.opencart.data;

import java.util.ArrayList;
import java.util.List;

import com.softserve.edu.opencart.pages.AMenuPage.CategoryRepository;
import com.softserve.edu.opencart.tools.CSVUtils;
import com.softserve.edu.opencart.tools.ExcelUtils;

public final class ProductRepository {

	private ProductRepository() {
	}
	
	public static IProduct getDesktopPc() {
		return  Product.get()
				.setDetails(new String())
				.setDescription(new String())
				.setPrice(new String())
				.setExTaxPrice(new String())
				.setCategoryName("Desctops")
				.setSubCategoryName("PC")
				.build();
	}

	public static IProduct getDesktopIMac() {
		return Product.get()
				.setDetails("iMac")
				.setDescription("Just when you thought iMac had everything, now there´s even more. More powerful Intel Core 2 Duo ..")
				.setPrice("122.0001")
				.setExTaxPrice("100.00")
				.setCategoryName("Desctops")
				.setSubCategoryName("Mac")
				.build();
	}

	public static IProduct getSamsungSyncMaster941BW() {
		return Product.get()
				.setDetails("Samsung SyncMaster 941BW")
				.setDescription("Imagine the advantages of going big without slowing down.")
				.setPrice("200.00")
				.setExTaxPrice("200.00")
				.setCategoryName(CategoryRepository.COMPONENTS.getCategory())
				.setSubCategoryName(CategoryRepository.COMPONENTS.getSubCategoriesByPartialName("Monitors"))
				.build();
	}

	public static List<IProduct> getDesktopIMacs() {
		List<IProduct> products = new ArrayList<IProduct>();
		products.add
			(Product.get()
				.setDetails("iMac")
				.setDescription("Just when you thought iMac had everything, now there´s even more. More powerful Intel Core 2 Duo ..")
				.setPrice("122.0001")
				.setExTaxPrice("100.00")
				.setCategoryName("Desctops")
				.setSubCategoryName("Mac")
				.build());
		products.add
			(Product.get()
				.setDetails("iMac")
				.setDescription("Just when you thought iMac had everything, now there´s even more. More powerful Intel Core 2 Duo ..")
				.setPrice("122.0001")
				.setExTaxPrice("100.00")
				.setCategoryName("Desctops")
				.setSubCategoryName("Mac")
				.build());
		return products;
	}

	public static List<IProduct> getLaptopHPs() {
		List<IProduct> products = new ArrayList<IProduct>();
		products.add
			(Product.get()
				.setDetails("HP LP3065")
				.setDescription("Stop your co-workers in their tracks with the stunning new 30-inch diagonal HP LP3065 Flat Panel ..")
				.setPrice("99.78")
				.setExTaxPrice("81.79")
				.setCategoryName("Laptops")
				.setSubCategoryName("HP")
				.build());
		products.add
			(Product.get()
				.setDetails("HP 250 G5")
				.setDescription("Take your work with you and quickly get the job done without stress or waiting around with the speed..")
				.setPrice("99.78")
				.setExTaxPrice("81.79")
				.setCategoryName("Laptops")
				.setSubCategoryName("HP")
				.build());
		products.add
			(Product.get()
				.setDetails("HP Pavilion x360")
				.setDescription("A1 are open boxed units which have been returned usually due to been unwanted. The units may have at..")
				.setPrice("433.46")
				.setExTaxPrice("433.46")
				.setCategoryName("Laptops")
				.setSubCategoryName("HP")
				.build());
		return products;
	}

	public static List<IProduct> getPhonesAndPDAs() {
		List<IProduct> products = new ArrayList<IProduct>();
//		IProduct p = Product.get()
//				.setDetails("HTC Touch HD")
//				.setDescription("HTC Touch - in High Definition. Watch music videos and streaming content in awe-inspiring high de..")
//				.setPrice("98.82")
//				.setExTaxPrice("81.00")
//				.setCategoryName("Phones")
//				.setSubCategoryName("HTC")
//				.build();
//		products.add(p);
		products.add
			(Product.get()
				.setDetails("HTC Touch HD")
				.setDescription("HTC Touch - in High Definition. Watch music videos and streaming content in awe-inspiring high de..")
				.setPrice("98.82")
				.setExTaxPrice("81.00")
				.setCategoryName("Phones")
				.setSubCategoryName("HTC")
				.build());
		products.add
			(Product.get()
				.setDetails("Palm Treo Pro")
				.setDescription("Redefine your workday with the Palm Treo Pro smartphone. Perfectly balanced, you can respond to b..")
				.setPrice("273.77")
				.setExTaxPrice("226.79")
				.setCategoryName("Phones")
				.setSubCategoryName("Others")
				.build());
		return products;
	}

	 public static List<IProduct> getComponentsMonitors() {
	        List<IProduct> products = new ArrayList<IProduct>();
	        products.add
	        	(Product.get()
					.setDetails("Apple Cinema 30\"")
					.setDescription("The 30-inch Apple Cinema HD Display")
					.setPrice("110.00")
					.setExTaxPrice("90.00")
					.setCategoryName("Components")
					.setSubCategoryName("Monitors")
					.build());
	        products.add
	        	(Product.get()
					.setDetails("Samsung SyncMaster 941BW")
					.setDescription("Imagine the advantages of going")
					.setPrice("242.00")
					.setExTaxPrice("200.00")
					.setCategoryName("Components")
					.setSubCategoryName("Monitors")
					.build());
	        return products;
	    }

	public static List<IProduct> getProductsFromCsvFile() {
		return new ProductDataUtils("/products.csv", new CSVUtils()).getAllProducts();
	}

	public static List<IProduct> getProductsFromCsvFile(String filename) {
		return new ProductDataUtils(filename, new CSVUtils()).getAllProducts();
	}

	public static List<IProduct> getProductsFromExcelFile() {
		return new ProductDataUtils("/products.xlsx", new ExcelUtils()).getAllProducts();
	}

	public static List<IProduct> getProductsFromExcelFile(String filename) {
		return new ProductDataUtils(filename, new ExcelUtils()).getAllProducts();
	}

//	public static List<IProduct> getProductFromDB() {
//		return new ProductUtils("/", new DBUtils()).getAllProduct();
//	}

}
