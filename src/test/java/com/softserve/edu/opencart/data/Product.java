package com.softserve.edu.opencart.data;

import com.softserve.edu.opencart.pages.AMenuPage.CategoryRepository;
import com.softserve.edu.opencart.tools.GeneralException;

//TODO use builder
public class Product {
	private static final String CATEGORY_NOT_FOUND_ERROR_MESSAGE = "Category not found";

	private String details;
	private String description;
	private String price;
	private String exTaxPrice;
	//
	private String categoryName;
	private String subCategoryName;
	private CategoryRepository category;
	private String subCategory;
	
	public Product(String details, String description,
			String price, String exTaxPrice,
			String categoryName, String subCategoryName) {
		this.details = details;
		this.description = description;
		this.price = price;
		this.exTaxPrice = exTaxPrice;
		this.categoryName = categoryName;
		this.subCategoryName = subCategoryName;
		//
		initCategory();
	}

	private void initCategory() {
		category = null;
		for (CategoryRepository currentCategory : CategoryRepository.values()) {
			if (currentCategory.getCategory().trim().toLowerCase()
					.contains(categoryName.trim().toLowerCase())) {
				category = currentCategory;
				break;
			}
		}
		if (category == null) {
			throw new GeneralException(CATEGORY_NOT_FOUND_ERROR_MESSAGE);
		}
		subCategory = category.getSubCategoriesByPartialName(subCategoryName);
	}
	
	public String getDetails() {
		return details;
	}

	public String getDescription() {
		return description;
	}

	public String getPrice() {
		return price;
	}

	public String getExTaxPrice() {
		return exTaxPrice;
	}

	public CategoryRepository getCategory() {
		return category;
	}

	public String getSubCategory() {
		return subCategory;
	}

}
