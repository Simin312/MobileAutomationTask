package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

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
	private By browseOption;
	private By getTaskName;

	
	public ProjectPage() {
		if(AppDriver.getCurrentDriver() instanceof AndroidDriver) {
			projectName = AppiumBy.xpath("//android.widget.TextView[@text=\"Create Project From API\"]");
			taskName = AppiumBy.xpath("//android.widget.EditText[@resource-id=\"android:id/message\"]");
			todayOption = AppiumBy.xpath("//androidx.compose.ui.platform.ComposeView[@resource-id=\"com.todoist:id/compose_navigation_holder\"]/android.view.View/android.view.View/android.view.View/android.view.View[1]");
			browseOption = 	AppiumBy.xpath("//androidx.compose.ui.platform.ComposeView[@resource-id=\"com.todoist:id/compose_navigation_holder\"]/android.view.View/android.view.View/android.view.View/android.view.View[4]");
			getTaskName =  AppiumBy.xpath("(//android.widget.TextView[@resource-id=\"com.todoist:id/text\"])[1]");
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
	
	public void createTask(String taskNameByUser) {
		quickAdd.click();
		waitNclick(taskName);
		waitNtype(taskName, taskNameByUser);
		addBtn.click();
		back();
		//pullToRefresh();
	}
	
	public void completeTask() {
		completeCheckBox.click();
	}
	
	public void refresh() {
		waitNclick(todayOption);
		waitNclick(browseOption);
	}
	
	public String getTaskName() {
		return getText(getTaskName);
	}
	
	
	
	
}
