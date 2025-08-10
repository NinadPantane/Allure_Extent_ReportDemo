package com.demo.extent;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class testngExtentReport {
	
	WebDriver driver;
	
	@BeforeClass
	public void setup() {
		 driver = new ChromeDriver();
		 
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 driver.manage().window().maximize();
		 driver.get("https://ecommerce-playground.lambdatest.io/");
	}
	
	@Test(priority=1)
	public void testLogo() {
		boolean logoStatus = driver.findElement(By.xpath("//a[@title='Poco Electro']/img")).isDisplayed();
		Assert.assertEquals(logoStatus,true);
	}
	
	@Test(priority=2)
	public void testAppURL() {
		Assert.assertEquals(driver.getCurrentUrl(), "https://ecommerce-playground.lambdatest.io/");
	}

	@Test(priority=3,dependsOnMethods = {"testAppURL"})
	public void testHomePageTitle() {
		Assert.assertEquals(driver.getTitle(), "Your Store");
	}
	
	@AfterClass
	void tearDown() {
		driver.quit();
	}
}
