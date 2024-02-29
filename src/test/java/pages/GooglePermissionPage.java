package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import driver.AppDriver;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

public class GooglePermissionPage extends BasePage{
	
	private By continueBtn;
	
	public GooglePermissionPage() {
		if(AppDriver.getCurrentDriver() instanceof AndroidDriver) {
			continueBtn = AppiumBy.xpath("//android.widget.TextView[@text=\"Continue\"]");
		}else if(AppDriver.getCurrentDriver() instanceof IOSDriver) {
		}
	}
	public void signinForTodoist() {
		waitNclick(continueBtn);
	}
}
