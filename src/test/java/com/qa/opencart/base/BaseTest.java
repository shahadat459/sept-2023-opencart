package com.qa.opencart.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;

import com.qa.opencart.factory.DriverFactory;
import com.qa.opencart.pages.AccountPage;
import com.qa.opencart.pages.LoginPage;
import com.qa.opencart.pages.ProductInfoPage;
import com.qa.opencart.pages.RegisterPage;
import com.qa.opencart.pages.ResultsPage;

public class BaseTest {

	protected  WebDriver driver;
	protected LoginPage loginPage;
	protected AccountPage accPage;
	protected ResultsPage resultsPage;
	protected ProductInfoPage productInfoPage;
	protected RegisterPage registerPage;
	

	protected DriverFactory df;
	protected Properties prop;

	protected SoftAssert softAssert;

	@BeforeTest
	public void setup() {
		df = new DriverFactory();
		prop = df.initProp();
		driver = df.initDriver(prop);
		loginPage = new LoginPage(driver);
		// productInfoPage = new  ProductInfoPage(driver);
		softAssert = new SoftAssert();
	}

	/*
	 * @Parameters({ "browser" })
	 * 
	 * @BeforeTest public void setup(String browserName) { df = new DriverFactory();
	 * prop = df.initProp();
	 * 
	 * if (browserName != null) { prop.setProperty("browser", browserName); }
	 * 
	 * driver = df.initDriver(prop);
	 * 
	 * loginPage = new LoginPage(driver); softAssert = new SoftAssert(); }
	 */
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
