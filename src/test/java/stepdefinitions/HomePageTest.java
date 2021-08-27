package stepdefinitions;



import java.util.ArrayList;

import org.openqa.selenium.Dimension;
import org.testng.Assert;

import com.sdet18.base.Base;
import com.sdet18.pageobjects.HomePage;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

/**
 * 
 * @author Nitheesha
 *
 */
public class HomePageTest extends Base{
	Base base;
	public HomePageTest(Base base) {
		this.base=base;
	}

	@When("Home page is displayed I will check whether logo is displayed or not")
	public void home_page_is_displayed_i_will_check_whether_logo_is_displayed_or_not() {
	   base.homePage=new HomePage(base.driver);
	   boolean logo=base.homePage.getApplicationLogo().isDisplayed();
	   Assert.assertTrue(false,"logo is not displayed");
	}
	@Then("get the height and width of of the logo")
	public void get_the_height_and_width_of_of_the_logo() {
	 Dimension dimension=  base.homePage.getHeightAndWidthOfLogo();
	 System.out.println(dimension.getHeight()+"\n"+dimension.getWidth());
	}
	
	@When("Home page is displayed click on Best sellers")
	public void home_page_is_displayed_click_on_best_sellers() {
	   base.homePage=new HomePage(base.driver);
	   base.homePage.getBestSellersLink().click();
	}
	@Then("I will get All the Text of dress")
	public void i_will_get_all_the_text_of_dress() {
	    ArrayList<String> list=base.homePage.getAllDressText();
	    System.out.println(list);
	}
}
