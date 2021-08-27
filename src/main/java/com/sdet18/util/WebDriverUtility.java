package com.sdet18.util;

import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.Select;
/**
 * This class contains the utility methods for webelement
 * @author Nitheesha
 *
 */
public class WebDriverUtility {
	/**
	 * Use this method for entering the value
	 * @param element
	 * @param text
	 */
	public void type(WebElement element,String text) {
		element.sendKeys(text);
	}
	/**
	 * Use this method for mouse hover action on element
	 * @param driver
	 * @param element
	 */
	public void mouseHover(WebDriver driver,WebElement element) {
		Actions act=new Actions(driver);
		act.moveToElement(element).perform();
	}
	
	/**
	 * Use this method for scroll down action
	 * @param driver
	 * @param element
	 */
	public void scrollDown(WebDriver driver, WebElement element) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		int y=element.getLocation().getY();
		js.executeScript("window.scrollBy(0,"+y+")", element);
		
	}
	/**
	 * If element is not intractable using selenium click call this method
	 * @param driver
	 * @param element
	 */
	public void jsClick(WebDriver driver,WebElement element) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", element);
	}
	/**
	 * Select the drop down based on index
	 * @param element
	 * @param index
	 */
	public void dropDown(WebElement element, int index) {
		Select sel=new Select(element);
		sel.selectByIndex(index);
	}
	/**
	 * Select dropdown based on visible text
	 * @param element
	 * @param visibleText
	 */
	public void dropDown(WebElement element, String visibleText) {
		Select sel=new Select(element);
		sel.selectByVisibleText(visibleText);
	}
	/**
	 * To accept alert popup
	 * @param driver
	 */
	public void acceptAlert(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	/**
	 * To dismiss alert popup
	 * @param driver
	 */
	public void dismissAlert(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	/**
	 * Takes screenshot in byte format
	 * @param driver
	 * @param screenshotName
	 * @return byte stream of screenshot
	 */
	public byte[] takeScreenShot(WebDriver driver) {
		EventFiringWebDriver event=new EventFiringWebDriver(driver);
		return event.getScreenshotAs(OutputType.BYTES);
		
	}
	
	/**
	 * Switch to the tab or new window opened by parent window 
	 * @param driver
	 * @param partialTitle
	 */
	public void switchToWindow(WebDriver driver,String partialTitle) {
		Set<String> window=driver.getWindowHandles();
		for(String w: window) {
			driver.switchTo().window(w);
			String title=driver.getTitle();
			if(title.contains(partialTitle)) {
				break;
			}
		}
	}
	
	

}
