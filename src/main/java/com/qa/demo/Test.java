package com.qa.demo;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.testng.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.goibibo.com/flights/air-BOM-DEL-20231023--1-0-0-E-D/?ft=sc");

		List ExPrices = new ArrayList<>(Arrays.asList("4,893", "4,994", "4,994"));
		List actPrices = new ArrayList<>();
		List<WebElement> prices = driver
				.findElements(By.xpath("//div[contains(@class,'srp-card-uistyles__Price-sc')]"));
		for (WebElement e : prices) {
			actPrices.add(e.getText());

		}
		 System.out.println(actPrices);
		Assert.assertEquals(actPrices, ExPrices);
	}

}
