package POM_Pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import helper.BasePage;

public class CheckoutPages_POM extends BasePage
{
private Logger log = LogManager.getLogger(CheckoutPages_POM.class);
	
	public CheckoutPages_POM(WebDriver wd) 
	{
        super(wd);
    }	
	// Locators repository
     @FindBy(id="first-name")WebElement txt_firstName;
     @FindBy(id="last-name")WebElement txt_lastName;
     @FindBy(id="postal-code")WebElement txt_zipCode;
     @FindBy(id="continue")WebElement btn_continue;
     @FindBy(id="finish")WebElement btn_finish;
     @FindBy(id="back-to-products")WebElement btn_back_home;

    
    // Actions repository
    public void enterDetails(String fname, String lname, String zip) {
    	txt_firstName.sendKeys(fname);
    	txt_lastName.sendKeys(lname);
    	txt_zipCode.sendKeys(zip);
    	btn_continue.click();
    	log.info("Shipping Address details entered");
    }

    public void clickFinish() {
        btn_finish.click();
        log.info("Clicked finish button and order placed");
    }
    
    public void click_on_Back_Home() {
        btn_back_home.click();
        log.info("Clicked on Back to Home button");
    }

}
