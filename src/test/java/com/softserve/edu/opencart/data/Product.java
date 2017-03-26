package com.softserve.edu.opencart.data;

import com.softserve.edu.opencart.pages.AMenuPage.CategoryRepository;
import com.softserve.edu.opencart.tools.GeneralException;

//TODO use builder


	interface IDetails {
		IDescription setDetails(String details);
	}
	
	interface IDescription {
		IPrice setDescription (String description);
	}
	
	interface IPrice {
		IExTaxPrice setPrice (String price);
	}
	
	interface IExTaxPrice {
		IProductAdditional setExTaxPrice(String exTaxPrice);
	}

	interface IBuildProduct {
		IProduct build();
	}

	interface IProductAdditional extends IBuildProduct {

		IProductAdditional setCategoryName(String categoryName);

		IProductAdditional setSubCategoryName(String subCategoryName);

		IProductAdditional setCategory(CategoryRepository category);

		IProductAdditional setSubCategory(String subCategory);
	}
	
	public class Product implements IDetails, IDescription, IPrice, 
									IExTaxPrice, IProductAdditional, IProduct {
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
	
	private Product() {
		//
		categoryName = new String();
		subCategoryName = new String();
		subCategory = new String();
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
	
	public static IDetails get() {
		return new Product();
	}

	
	//setters
	public IDescription setDetails(String details){
		details = this.details;
		return this;
	}
	
	public IPrice setDescription(String description){
		description = this.description;
		return this;
	}

	public IExTaxPrice setPrice(String price){
		price = this.price;
		return this;
	}
	
	public IProductAdditional setExTaxPrice(String exTaxPrice){
		exTaxPrice = this.exTaxPrice;
		return this;
	}
	
	public IProduct build() {
		return this;
	}
	
	//
	
	public IProductAdditional setCategoryName(String categoryName){
		categoryName = this.categoryName;
		return this;
	}
	
	public IProductAdditional setSubCategoryName(String subCategoryName){
		subCategoryName = this.subCategoryName;
		return this;
	}
	
	public IProductAdditional setCategory(CategoryRepository category){
		category = this.category;
		return this;
	}
	
	public IProductAdditional setSubCategory(String subCategory){
		subCategory = this.subCategory;
		return this;
	}
	
	//getters
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
