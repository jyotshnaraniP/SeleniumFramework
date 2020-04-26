package MyAcademy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Resources.Base;
import pageObects.LandingPage;
import pageObects.LoginPage;

public class ValidateNavigationBar extends Base{
public static Logger log=LogManager.getLogger(Base.class.getName());

	
	@BeforeTest
	public void initialize() throws IOException {
		
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		
	}
	
	@Test
	public void basePageNavigation()
	{
		
		LandingPage l = new LandingPage(driver);
		Assert.assertTrue(l.getNavigationBar().isDisplayed(), "The navigation is NOT displayed");		
		log.info("Navigation bar is displayed.");

		
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.close();
		driver=null;
	}
}
