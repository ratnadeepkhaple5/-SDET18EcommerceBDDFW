package hook;
/**
 * 
 * @author Nitheesha
 *
 */

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.sdet18.base.Base;
import com.sdet18.util.PropertyFileUtility;
import com.sdet18.util.WebDriverUtility;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Hook extends Base{
	
	Base base;
	public Hook(Base base) {
		this.base=base;
	}

	@Before
	public void setUp() throws Throwable {
		base.propertyFileUtility=new PropertyFileUtility();
		base.propertyFileUtility.loadProperty();
		base.webdriverUtility=new WebDriverUtility();
		String browser=base.propertyFileUtility.getBrowser();
		if(browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			base.driver=new ChromeDriver();
		}else if(browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			base.driver=new FirefoxDriver();
		}
		base.driver.manage().window().maximize();
		base.driver.manage().timeouts().implicitlyWait(base.propertyFileUtility.getImplicitWait(), TimeUnit.SECONDS);
		base.driver.get(base.propertyFileUtility.getUrl());
	}
	
	@After
	public void tearDown(Scenario scenario) {
		if(scenario.isFailed()) {
			byte[] screenshot=base.webdriverUtility.takeScreenShot(base.driver);
			scenario.attach(screenshot, "image/png", scenario.getName());
		}
		base.driver.close();
	}
}
