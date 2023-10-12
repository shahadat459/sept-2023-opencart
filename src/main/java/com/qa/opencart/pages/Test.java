package com.qa.opencart.pages;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.qa.opencart.utils.ElementUtil;

public class Test {

	public static void main(String[] args) {
		By link = By.linkText("OrangeHRM, Inc");
		WebDriver driver = new ChromeDriver();
		ElementUtil eleUtil = new ElementUtil(driver);
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		eleUtil.doClick(link);
		
		String parentWinId = driver.getWindowHandle();
		System.out.println("Parent window:"+parentWinId);
		
		Set<String> allWinIds = driver.getWindowHandles();
		System.out.println("All windows:" + allWinIds);
		Iterator<String> it = allWinIds.iterator();
		String P = it.next();
		String C = it.next();
		
		System.out.println("Parent:" + P + " "+ "Child:" + C);
		
		Actions action = new Actions(driver);
			
	}

}
