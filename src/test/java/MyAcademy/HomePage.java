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

public class HomePage extends Base{
	public static Logger log=LogManager.getLogger(Base.class.getName());

	
	@BeforeTest
	public void initialize() throws IOException {
		
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();		
	}
		
	@Test(dataProvider="getData")
	public void basePageNavigation(String UserName, String Password, String text) throws IOException{
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		LandingPage l = new LandingPage(driver);	
		l.getLogin().click();		
		LoginPage lp = new LoginPage(driver);
		lp.getEmail().sendKeys(UserName);
		lp.getPassword().sendKeys(Password);
		lp.getLogin().click();	
		log.info(text);

	}
	
	@DataProvider
	
	public Object[][] getData() {
		Object[][] data=new Object[2][3];
		data[0][0]="nonrestricted@wc.com";
		data[0][1]="12345";
		data[0][2]="Non Restricted User";
		
		data[1][0]="restricted@wc.com";
		data[1][1]="125450";
		data[1][2]="Restricted User";
		
		return data;
	}
	
	@AfterTest
	public void teardown()
	{
		driver.close();
		driver=null;
	}

}
