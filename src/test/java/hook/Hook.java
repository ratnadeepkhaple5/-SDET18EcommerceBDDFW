package hook;
/**
 * 
 * @author Nitheesha
 *
 */

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.sdet18.base.Base;
import com.sdet18.util.PropertyFileUtility;
import com.sdet18.util.WebDriverUtility;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Hook extends Base{
	
	public static final String USERNAME = "nitheshdemo1";
	public static final String AUTOMATE_KEY = "g4dQq823QMsLNUFrbzX3";
	public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";
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
		String remote=base.propertyFileUtility.getRemote();
		//String browser=System.getProperty("BROWSER");
		if(remote.equals("none")) {
		if(browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			base.driver=new ChromeDriver();
		}else if(browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			base.driver=new FirefoxDriver();
		}
		}else if(remote.equals("ios")){
			DesiredCapabilities cap=new DesiredCapabilities();
			cap.setCapability(CapabilityType.BROWSER_NAME, "chrome");
			cap.setCapability("browser_version", "49");
			cap.setCapability("os", "Windows");
			cap.setCapability("os_version", "XP");
			cap.setCapability("build", "build 1.0");
			cap.setCapability("name", "My First test run in windows xp");
			
			base.driver=new RemoteWebDriver(new URL(URL), cap);
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
