package com.sdet18.pageobjects;
/**
 * 
 * @author Nitheesha
 *
 */


import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//img[@alt='My Store']")
	private WebElement applicationLogo;
	
	@FindBy(xpath="//a[text()='Best Sellers']")
	private WebElement bestSellersLink;
	
	@FindBy(xpath="//a[@class='product-name']")
	private List<WebElement> dressNames;

	public WebElement getApplicationLogo() {
		return applicationLogo;
	}

	public WebElement getBestSellersLink() {
		return bestSellersLink;
	}

	public List<WebElement> getDressNames() {
		return dressNames;
	}
	
	public Dimension getHeightAndWidthOfLogo() {
		return applicationLogo.getSize();
	}
	
	public ArrayList<String> getAllDressText() {
		ArrayList<String> list=new ArrayList<String>();
		for(int i=0;i<dressNames.size();i++) {
			list.add(dressNames.get(i).getText());
		}
		return list;
	}
}
