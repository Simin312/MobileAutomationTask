package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import base.Util;
import driver.AppDriver;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class ProjectPage extends BasePage{
	private By projectName;
	private By taskName;
	private By todayOption;
	private By inboxOption;
	private By searchOption;
	private By browseOption;
	private By getTaskName;

	
	public ProjectPage() {
		if(AppDriver.getCurrentDriver() instanceof AndroidDriver) {
			projectName = AppiumBy.xpath("//android.widget.TextView[@text=\"Create Project From API\"]");
			taskName = AppiumBy.xpath("//android.widget.EditText[@resource-id=\"android:id/message\"]");
			todayOption = AppiumBy.xpath("//androidx.compose.ui.platform.ComposeView[@resource-id=\"com.todoist:id/compose_navigation_holder\"]/android.view.View/android.view.View/android.view.View/android.view.View[1]");
			inboxOption = AppiumBy.xpath("//androidx.compose.ui.platform.ComposeView[@resource-id=\"com.todoist:id/compose_navigation_holder\"]/android.view.View/android.view.View/android.view.View/android.view.View[2]");
			searchOption = AppiumBy.xpath("//androidx.compose.ui.platform.ComposeView[@resource-id=\"com.todoist:id/compose_navigation_holder\"]/android.view.View/android.view.View/android.view.View/android.view.View[3]");
			browseOption = 	AppiumBy.xpath("//androidx.compose.ui.platform.ComposeView[@resource-id=\"com.todoist:id/compose_navigation_holder\"]/android.view.View/android.view.View/android.view.View/android.view.View[4]");
			getTaskName =  AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.todoist:id/text\"]");
			
		}else if(AppDriver.getCurrentDriver() instanceof IOSDriver) {	
		}
	}
	
	@AndroidFindBy(accessibility = "Quick add")
	@iOSXCUITFindBy(accessibility = "Quick add")
	private WebElement quickAdd;
	
	@AndroidFindBy(accessibility = "Add")
	@iOSXCUITFindBy(accessibility = "Add")
	private WebElement addBtn;
	
	@AndroidFindBy(accessibility = "Complete")
	@iOSXCUITFindBy(accessibility = "Complete")
	private WebElement completeCheckBox;
	
	public void waitForProjectPageLoad() {
		waitForEl(projectName);
	}
	
	public void createTask(String taskNameByUser) throws InterruptedException {
		quickAdd.click();
		waitNclick(taskName);
		waitNtype(taskName, taskNameByUser);
		addBtn.click();
		back();
		Util.scrollToTop();
	}
	
	public void completeTask() {
		if(completeCheckBox.isDisplayed()) {
			completeCheckBox.click();
		}
	}
	
	public void refresh() throws InterruptedException {
		Thread.sleep(2000);
		Util.scrollToTop();
	}
	
	public String getTaskName() {
		// is text contain?
		return getText(getTaskName);
	}
}
