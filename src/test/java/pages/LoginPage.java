// For MYDEMOAPP
package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import driver.AppDriver;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class LoginPage extends BasePage{
	// Username input field
	// Password input field
	// Login button
	private By userName;
	public LoginPage(){
		if(AppDriver.getCurrentDriver() instanceof AndroidDriver) {
			userName = AppiumBy.accessibilityId("Username input field");
		}else if(AppDriver.getCurrentDriver() instanceof IOSDriver) {
			userName = AppiumBy.accessibilityId("");
		}
	}
	
	@AndroidFindBy(accessibility = "Password input field")
	@iOSXCUITFindBy(accessibility = "")
	private WebElement Password;
	
	@AndroidFindBy(accessibility = "Login button")
	@iOSXCUITFindBy(accessibility = "")
	private WebElement btnLogin;
	
	MenuPage menuPage = new MenuPage();
	
	public void login(String username, String password) {
		//menuPage.navitageToLogin();
		waitNtype(userName, username);
		Password.sendKeys(password);
		btnLogin.click();
	}
	
	
	
}
