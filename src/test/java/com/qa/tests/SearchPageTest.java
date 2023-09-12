package com.qa.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;

public class SearchPageTest extends BaseTest {

	@BeforeClass
	public void searchSetup() {
		accPage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}

	@Test // (dataProvider = "productDataWithSearchKey", dataProviderClass =
			// ProductDataProvider.class)
	public void searchProductResultCountTest() {
		resultsPage = accPage.doSearch("Macbook");
		Assert.assertTrue(resultsPage.getProductResultsCount() > 0);
	}

	@Test // (dataProvider = "productDataWithSearchKey", dataProviderClass =
			// ProductDataProvider.class)
	public void searchPageTitleTest() {
		resultsPage = accPage.doSearch("Macbook");
		String actSearchTitle = resultsPage.getResultsPageTitle("Macbook");
		System.out.println("Search Page Title : " + actSearchTitle);
		Assert.assertEquals(actSearchTitle, "Search - " + "Macbook");
	}

	@Test // (dataProvider = "productDataWithName", dataProviderClass =
			// ProductDataProvider.class)
	public void selectProductTest() {
		resultsPage = accPage.doSearch("Macbook");
		productInfoPage = resultsPage.selectProduct("MacBook Pro");
		String actProductHeaderName = productInfoPage.getProductHeaderName();
		System.out.println("actual product name : " + actProductHeaderName);
		Assert.assertEquals(actProductHeaderName, "MacBook Pro");
	}

	@Test // (dataProvider = "productDataWithImage", dataProviderClass =
			// ProductDataProvider.class)
	public void productImagesTest() {
		resultsPage = accPage.doSearch("Macbook");
		productInfoPage = resultsPage.selectProduct("MacBook Pro");
		int actProductImagesCount = productInfoPage.getProductImagesCount();
		System.out.println("actual product images count : " + actProductImagesCount);
		Assert.assertEquals(actProductImagesCount, 4);
	}
}
