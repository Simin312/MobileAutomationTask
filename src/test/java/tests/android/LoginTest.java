// For MYDEMOAPP
package tests.android;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import driver.AppDriver;
import pages.LoginPage;
import pages.MenuPage;
import pages.ProductPage;

public class LoginTest extends BaseTest{
	@Test
	public static void validLoginTest() {
		//AppDriver.getCurrentDriver().
		MenuPage menuPage = new MenuPage();
		LoginPage loginPage = new LoginPage();
		ProductPage productPage = new ProductPage();
		
		menuPage.navitageToLogin();
		loginPage.login("bob@example.com", "10203040");
		Assert.assertTrue(productPage.waitForProductText());
	}
}
