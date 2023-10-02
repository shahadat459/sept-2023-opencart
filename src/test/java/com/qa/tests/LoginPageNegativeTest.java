package com.qa.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;

public class LoginPageNegativeTest extends BaseTest {
	@DataProvider
	public Object[][] incorrectLoginTestData() {
		return new Object[][] { { "auto12344@gmaill.com", "14423456" }, 
			{ "test14@@gmaill.com", "1234456" }};

	}

	@Test(dataProvider = "incorrectLoginTestData")
	public void loginWithWrongCredentialsTest(String userName, String password) {
		Assert.assertTrue(loginPage.doLoginWithWrongCredentials(userName, password));
	}

}
