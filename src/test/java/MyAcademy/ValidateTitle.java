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

public class ValidateTitle extends Base{
	public static Logger log=LogManager.getLogger(Base.class.getName());
	
	@BeforeTest
	public void initialize() throws IOException {
		
		driver = initializeDriver();
		log.info("Driver is initialized");
		driver.get(prop.getProperty("url"));
		log.info("Navigate to the home page.");
		driver.manage().window().maximize();
		
	}
		
	@Test
	public void basePageNavigation()
	{
		LandingPage l = new LandingPage(driver);
		Assert.assertEquals(l.getTitle().getText(), "FEATURED COURSES");	
		log.info("Sucessfully validated the text message");
	}
	
	@AfterTest
	public void teardown()
	{
		driver.close();
		driver=null;
	}
}
