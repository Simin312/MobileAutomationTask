package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import driver.AppDriver;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class HomePage extends BasePage{

	By moreOption = AppiumBy.accessibilityId("More options");
	private By todayOption;
	private By inboxOption;
	private By searchOption;
	private By browseOption;
	
	public HomePage() {
		if(AppDriver.getCurrentDriver() instanceof AndroidDriver) {
			todayOption = AppiumBy.xpath("//androidx.compose.ui.platform.ComposeView[@resource-id=\"com.todoist:id/compose_navigation_holder\"]/android.view.View/android.view.View/android.view.View/android.view.View[1]");
			inboxOption = AppiumBy.xpath("//androidx.compose.ui.platform.ComposeView[@resource-id=\"com.todoist:id/compose_navigation_holder\"]/android.view.View/android.view.View/android.view.View/android.view.View[2]");
			searchOption = AppiumBy.xpath("//androidx.compose.ui.platform.ComposeView[@resource-id=\"com.todoist:id/compose_navigation_holder\"]/android.view.View/android.view.View/android.view.View/android.view.View[3]");
			browseOption = AppiumBy.xpath("//androidx.compose.ui.platform.ComposeView[@resource-id=\"com.todoist:id/compose_navigation_holder\"]/android.view.View/android.view.View/android.view.View/android.view.View[4]");
		}else if(AppDriver.getCurrentDriver() instanceof IOSDriver) {
			
		}
	}
	
	public boolean waitForMoreOption() {
		return waitForEl(moreOption).isDisplayed();
	}
	
	public void navigateToBrowse() {
		waitNclick(browseOption);
	}
	
	
}
