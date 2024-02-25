package tests.android;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
import pages.MenuPage;
import pages.ProductPage;

public class ProductsTest extends BaseTest{
	MenuPage menuPage;
	LoginPage loginPage;
	ProductPage productPage;
	
	@Test 
	public void ProductsValidateTest() throws InterruptedException {
		menuPage = new MenuPage();
		loginPage = new LoginPage();
		productPage = new ProductPage();
		
		Assert.assertEquals(productPage.getItemCount(), 6);
		
		productPage.sortBy();
		Thread.sleep(1000);
		Assert.assertEquals(productPage.getFirstProductPrice(), "$29.99");
		Assert.assertEquals(productPage.getFirstProductName(), "Sauce Labs Backpack");
	}
}
