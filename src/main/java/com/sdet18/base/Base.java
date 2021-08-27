package com.sdet18.base;

import org.openqa.selenium.WebDriver;

import com.sdet18.pageobjects.HomePage;
import com.sdet18.util.PropertyFileUtility;
import com.sdet18.util.WebDriverUtility;

public class Base {
	
	public WebDriver driver;
	public PropertyFileUtility propertyFileUtility;
	public WebDriverUtility webdriverUtility;
	public HomePage homePage;

}
