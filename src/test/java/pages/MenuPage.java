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

public class MenuPage extends BasePage {
	// open menu
	// menu item log in
	
	By menuOption;
	public MenuPage(){
		if(AppDriver.getCurrentDriver() instanceof AndroidDriver) {
			menuOption = AppiumBy.accessibilityId("open menu");
		}else if(AppDriver.getCurrentDriver() instanceof IOSDriver) {
			menuOption = AppiumBy.accessibilityId("");
		}
	}
	
	@AndroidFindBy(accessibility = "menu item log in")
	@iOSXCUITFindBy(accessibility = "menu item log in")
	public WebElement menuLogin;
	
	public void navitageToLogin() {
		waitNclick(menuOption);
		menuLogin.click();
	}
}
