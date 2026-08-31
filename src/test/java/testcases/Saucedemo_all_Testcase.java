package testcases;
import java.io.IOException;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import POM_Pages.CartPage_POM;
import POM_Pages.CheckoutPages_POM;
import POM_Pages.HomePage_ProductPage_POM;
import POM_Pages.LoginPage_POM;
import helper.BaseTest;
import utility_Files.Excel_Utility;
import utility_Files.Wait_Utility;

public class Saucedemo_all_Testcase extends BaseTest{
	@Test(priority = 0)
    public void login_testcase() throws IOException, InterruptedException 
	{		
        // 1. Login using Excel Data
        String user = Excel_Utility.getCellData("C:\\Users\\hp\\Documents\\SELENIUM_WORKSPACE\\Saucedemo_Test\\src\\test\\resources\\Test_data.xlsx", "saucedemo_Login", 1, 0);
        String pass = Excel_Utility.getCellData("C:\\Users\\hp\\Documents\\SELENIUM_WORKSPACE\\Saucedemo_Test\\src\\test\\resources\\Test_data.xlsx", "saucedemo_Login", 1, 1);
        LoginPage_POM l = new LoginPage_POM(wd);
        HomePage_ProductPage_POM h = new HomePage_ProductPage_POM(wd);
        
        l.login(user, pass);
        Thread.sleep(2000);
     //   Wait_Utility.waitForElementClickable(wd, By.id("logout_sidebar_link"),10);
        h.logout_process();
        log.info("Login and Logout Successful");
	}
	
	@Test(priority = 2)
	public void add_to_cart_testcase() throws IOException, InterruptedException 
	{		
        // 2. Add Product to Cart
		String user = Excel_Utility.getCellData("C:\\Users\\hp\\Documents\\SELENIUM_WORKSPACE\\Saucedemo_Test\\src\\test\\resources\\Test_data.xlsx", "saucedemo_Login", 1, 0);
        String pass = Excel_Utility.getCellData("C:\\Users\\hp\\Documents\\SELENIUM_WORKSPACE\\Saucedemo_Test\\src\\test\\resources\\Test_data.xlsx", "saucedemo_Login", 1, 1);																							
	    LoginPage_POM l = new LoginPage_POM(wd);
	    HomePage_ProductPage_POM h = new HomePage_ProductPage_POM(wd);
	        
	    l.login(user, pass);
	    log.info("Login Successful");
	    Thread.sleep(2000);
	  
   //     Wait_Utility.waitForElementClickable(wd, By.id("add-to-cart-sauce-labs-backpack"),10);
        h.click_on_add_to_cart_button();
        Thread.sleep(2000);
        h.click_on_cart_icon();
        log.info("Product added and cart opened");
        
   //     Wait_Utility.waitForElementClickable(wd, By.id("logout_sidebar_link"),10);
        h.logout_process();
        log.info("User logged out");
	}
	
	@Test(priority = 3)
	public void checkout_n_address_testcase() throws IOException, InterruptedException 
	{
        // 3. Checkout & Address
		String user = Excel_Utility.getCellData("C:\\Users\\hp\\Documents\\SELENIUM_WORKSPACE\\Saucedemo_Test\\src\\test\\resources\\Test_data.xlsx", "saucedemo_Login", 1, 0);
        String pass = Excel_Utility.getCellData("C:\\Users\\hp\\Documents\\SELENIUM_WORKSPACE\\Saucedemo_Test\\src\\test\\resources\\Test_data.xlsx", "saucedemo_Login", 1, 1);
	    String fname = Excel_Utility.getCellData("C:\\Users\\hp\\Documents\\SELENIUM_WORKSPACE\\Saucedemo_Test\\src\\test\\resources\\Test_data.xlsx", "saucedemo_address", 1, 2);
	    String lname = Excel_Utility.getCellData("C:\\Users\\hp\\Documents\\SELENIUM_WORKSPACE\\Saucedemo_Test\\src\\test\\resources\\Test_data.xlsx", "saucedemo_address", 1, 3);
	    String zip = Excel_Utility.getCellData("C:\\Users\\hp\\Documents\\SELENIUM_WORKSPACE\\Saucedemo_Test\\src\\test\\resources\\Test_data.xlsx", "saucedemo_address", 1, 4);
	    
	    LoginPage_POM l = new LoginPage_POM(wd);
	    HomePage_ProductPage_POM h = new HomePage_ProductPage_POM(wd);
	    CartPage_POM ct = new CartPage_POM(wd);
	    CheckoutPages_POM ch = new CheckoutPages_POM(wd);
	        
	    l.login(user, pass);
	    log.info("Login Successful");
	    Thread.sleep(2000);
		  
//        Wait_Utility.waitForElementClickable(wd, By.id("add-to-cart-sauce-labs-backpack"),10);
        h.click_on_add_to_cart_button();
        Thread.sleep(2000);
        h.click_on_cart_icon();
        log.info("Product added and cart opened");
        Thread.sleep(2000);
        
		ct.click_on_checkout_button();
		log.info("Navigates to Checkout page for adding address details");
		 Thread.sleep(2000);
		
		ch.enterDetails(fname, lname, zip);
		log.info("Address details entered");
		 Thread.sleep(2000);
		
		ch.clickFinish();
		 Thread.sleep(2000);
		String successMsg = wd.findElement(By.className("complete-header")).getText();
        Assert.assertEquals(successMsg, "Thank you for your order!");
        log.info("Order placed successfully");
		
		ch.click_on_Back_Home();
		log.info("Navigate to home or product page");
		 Thread.sleep(2000);
		
  //      Wait_Utility.waitForElementClickable(wd, By.id("logout_sidebar_link"),10);
        h.logout_process();
        log.info("User logged out");
        Thread.sleep(2000);
    }
}
