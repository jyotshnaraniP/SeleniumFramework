package pageObects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	
	public WebDriver driver;
	By signIn = By.cssSelector("a[href*='sign_in'");
	By title = By.xpath("//*[@id=\"content\"]//h2");
	By navigationBar=By.xpath("//ul[@class='nav navbar-nav navbar-right']");

	
	public WebElement getLogin() {
		
		return driver.findElement(signIn);
	}
	
public WebElement getTitle() {
		
		return driver.findElement(title);
	}

public WebElement getNavigationBar() {
	
	return driver.findElement(navigationBar);
}

	public LandingPage(WebDriver driver2) {
		// TODO Auto-generated method stub
		this.driver = driver2;
		
	}

}
