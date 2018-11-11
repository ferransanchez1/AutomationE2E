package stepDefinitions;

import org.junit.runner.RunWith;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.junit.Cucumber;
import junit.framework.Assert;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import pageObjects.PortalHomePage;
import resources.base;

@RunWith(Cucumber.class)
public class stepDefinition extends base {
	
	//Scenario: Positive test validation login
    @Given("^Initalize the browser with chrome$")
    public void initalize_the_browser_with_chrome() throws Throwable {
		 driver =initializeDriver();
    }
    @And("^Navigate to \"([^\"]*)\" Site$")
    public void navigate_to_something_site(String strArg1) throws Throwable {
    	driver.get(strArg1);
    	driver.manage().window().maximize();

    }
    @And("^Click on Login link in home page to land in secure sign in Page$")
    public void click_on_login_link_in_home_page_to_land_in_secure_sign_in_page() throws Throwable {
    	LandingPage l=new LandingPage(driver);
    	//Click on pop-up NO THANKS if it is exist
    	if (l.getPopupSize()>0)
    	{
    		l.getPopup().click();
    		
    	}
		l.getLogin().click(); //driver.findElement(By.css()

    }    
    @When("^Users enter (.+) and (.+) and logs in$")
    public void users_enter_and_and_logs_in(String username, String password) throws Throwable {
    	LoginPage lp=new LoginPage(driver);
		lp.getEmail().sendKeys(username);
		lp.getPassword().sendKeys(password);
		lp.getLogin().click();
    	
    }
    @Then("^Verify that user is succesfully logged in$")
    public void verify_that_user_is_succesfully_logged_in() throws Throwable {
    	PortalHomePage p=new PortalHomePage(driver);
   		Assert.assertTrue(p.getSearchBox().isDisplayed());
    }
    @And("^Close all browsers$")
    public void close_all_browsers() throws Throwable {
    	driver.quit();

    }
    //Scenario: Negative test validation login
    @Then("^Verify that user fails logged in$")
    public void verify_that_user_fails_logged_in() throws Throwable {
    	PortalHomePage a=new PortalHomePage(driver);
    	Assert.assertTrue(a.errorMessage().isDisplayed());
    }

}
