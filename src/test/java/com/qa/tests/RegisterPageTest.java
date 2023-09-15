package com.qa.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.qa.opencart.base.BaseTest;
import com.qa.opencart.utils.AppConstants;
import com.qa.opencart.utils.ExcelUtil;

public class RegisterPageTest extends BaseTest {

	@BeforeClass
	public void regSetup() {
		registerPage = loginPage.navigateToRegisterPage();
	}

	public String getRandomEmailID() {
		return "testautomation" + System.currentTimeMillis() + "@gmail.com";
		// return "testautomation" + UUID.randomUUID()+"@gmail.com";
	}

	@DataProvider(name = "regData")
	public Object[][] getUserRegTestData() {
		return new Object[][] { { "Shaan", "khan", "1245785621", "shaan@123", "yes" },
				{ "Ayan", "Shaikh", "1232216578", "ayan@123", "no" },
				{ "ashshu", "matoli", "8798873254", "ashshu@123", "yes" }, };
	}

	/*
	 * @DataProvider(name = "regExcelData") public Object[][] getRegExcelTestData()
	 * { Object regData[][] =
	 * ExcelUtil.getTestData(AppConstants.REGISTER_SHEET_NAME); return regData; }
	 */

	@Test(dataProvider = "regData")
	public void userRegisterTest(String firstName, String lastName, String telephone, String password,
			String subscribe) {
		String actRegSuccMessg = registerPage.registerUser(firstName, lastName, getRandomEmailID(), telephone, password,
				subscribe);
		Assert.assertEquals(actRegSuccMessg, AppConstants.USER_RESG_SUCCESS_MESSG);
	}

}
