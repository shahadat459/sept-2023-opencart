package com.qa.opencart.dataproviders;

import org.testng.annotations.DataProvider;

import com.qa.opencart.pojo.Product;

public class ProductDataProvider {
	@DataProvider(name = "productData")
	public Object[][] getProdutTestData() {
		return new Object[][] { 
			{ new Product("Macbook", "MacBook Pro", 4) }, 
			{ new Product("iMac", "iMac", 3) },
			{ new Product("Samsung", "Samsung SyncMaster 941BW", 1) },
			{ new Product("Samsung", "Samsung Galaxy Tab 10.1", 7) } 
			};
	}

	@DataProvider(name = "prodcutDataWithSearchKey")
	public Object[][] getProductSearchKeyData() {
		return new Object[][] { 
			{ "Macbook" }, 
			{ "iMac" }, 
			{ "Samsung" } 
			};
	}

	@DataProvider(name = "productDataWithProductName")
	public Object[][] getProductData() {
		return new Object[][] { 
			{ "Macbook", "MacBook Pro" }, 
			{ "iMac", "iMac" },
			{ "Samsung", "Samsung SyncMaster 941BW" }, 
			{ "Samsung", "Samsung Galaxy Tab 10.1" } 
			};
	}

	@DataProvider(name = "productDataWithImgCount")
	public Object[][] getProductImageTestData() {
		return new Object[][] { 
			{ "Macbook", "MacBook Pro", 4 }, 
			{ "iMac", "iMac", 3 },
			{ "Samsung", "Samsung SyncMaster 941BW", 1 }, 
			{ "Samsung", "Samsung Galaxy Tab 10.1", 7 } 
			};

	}
}