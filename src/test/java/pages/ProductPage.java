// For MYDEMOAPP
package pages;

import org.openqa.selenium.By;

import driver.AppDriver;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

public class ProductPage extends BasePage{
	
	//@AndroidFindBy
	By productPage;
	public ProductPage() {
		if(AppDriver.getCurrentDriver() instanceof AndroidDriver) {
			productPage = AppiumBy.accessibilityId("container header");
		}else if(AppDriver.getCurrentDriver() instanceof IOSDriver) {
			productPage = AppiumBy.accessibilityId("container header");
		}
	}

	public boolean waitForProductText() {
		return waitForEl(productPage).isDisplayed();
	}
	// container header -> should contain Product

}
