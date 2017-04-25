package com.softserve.edu.opencart.data;

import java.util.ArrayList;
import java.util.List;

import com.softserve.edu.opencart.tools.IExternalData;

public final class ProductDataUtils {
	private String path;
	private IExternalData externalData;

	public ProductDataUtils(String path, IExternalData externalData) {
		this.path = path;
		this.externalData = externalData;
	}

	public List<IProduct> getAllProducts() {
		//System.out.println("+++ Path to file: "
		//		+ this.getClass().getResource(path).getPath());
		return getAllProducts(this.getClass()
				.getResource(path).getPath().substring(1));
	}

	public List<IProduct> getAllProducts(String connection) {
		List<IProduct> products = new ArrayList<IProduct>();
		for (List<String> row : externalData.getAllCells(connection)) {
			if (row.get(2).toLowerCase().contains("price")
					&& row.get(3).toLowerCase().contains("extaxprice")) {
				continue;
			}
			//System.out.println("\t+++new Product: " + row.get(0));
			// TODO Use Builder.
			products.add(Product.get()
					.setDetails(row.get(0))
					.setDescription(row.get(1))
					.setPrice(row.get(2))
					.setExTaxPrice(row.get(3))
					.setCategoryName(row.get(4))
					.setSubCategoryName(row.get(5))
					.build());//should return IProduct
		}
		return products;
	}

}
