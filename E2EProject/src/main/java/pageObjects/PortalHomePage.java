package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PortalHomePage {
	
	public WebDriver driver;
	
	By searchBox=By.id("search-courses");
	By alertMessage=By.xpath("//div[@class='alert alert-danger']");
		
	
	public PortalHomePage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		
		this.driver=driver;
	}

	public WebElement getSearchBox()
	{
		return driver.findElement(searchBox);
	}
	
	//alert message is displayed when username or password fails
	public WebElement errorMessage()
	{
		return driver.findElement(alertMessage);
	}
}
