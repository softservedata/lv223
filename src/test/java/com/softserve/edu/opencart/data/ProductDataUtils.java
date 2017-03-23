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

	public List<Product> getAllProduct() {
		System.out.println("+++ Path to file: "
				+ this.getClass().getResource(path).getPath());
		return getAllProduct(this.getClass()
				.getResource(path).getPath().substring(1));
	}

	public List<Product> getAllProduct(String connection) {
		List<Product> products = new ArrayList<Product>();
		for (List<String> row : externalData.getAllCells(connection)) {
			if (row.get(2).toLowerCase().contains("price")
					&& row.get(3).toLowerCase().contains("extaxprice")) {
				continue;
			}
			//System.out.println("\t+++new Product: " + row.get(0));
			products.add(new Product(row.get(0), row.get(1),
					row.get(2), row.get(3), row.get(4), row.get(5)));
		}
		return products;
	}

}
