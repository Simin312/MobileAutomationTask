package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import driver.AppDriver;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class BrowsePage extends BasePage{

	private By addProject;
	private By projectName;
	private By getCreatedProjectName;
	
	public BrowsePage() {
		if(AppDriver.getCurrentDriver() instanceof AndroidDriver) {
			addProject = AppiumBy.xpath("//android.widget.TextView[@text=\"Add project\"]");
			projectName = AppiumBy.xpath("//android.widget.EditText[@resource-id=\"com.todoist:id/name\"]");
			getCreatedProjectName = AppiumBy.xpath("//androidx.compose.ui.platform.ComposeView/descendant::android.widget.TextView[contains(@text, 'Create Project From API')]");
		}else if(AppDriver.getCurrentDriver() instanceof IOSDriver) {	
		}
	}
	
	@AndroidFindBy(accessibility = "Add")
	@iOSXCUITFindBy(accessibility = "Add")
	private WebElement addBtn;
	
	@AndroidFindBy(accessibility = "Done")
	@iOSXCUITFindBy(accessibility = "Done")
	private WebElement doneBtn;
	
	public String getProjectName() {
		return getText(getCreatedProjectName);
	}
	
	public void navigateToProject() {
		waitNclick(getCreatedProjectName);
	}
}
