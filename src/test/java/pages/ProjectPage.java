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
	
	
	public ProjectPage() {
		if(AppDriver.getCurrentDriver() instanceof AndroidDriver) {
			projectName = AppiumBy.xpath("//android.widget.TextView[@text=\"Create Project From API\"]");
			taskName = AppiumBy.xpath("//android.widget.EditText[@resource-id=\"android:id/message\"]");
		}else if(AppDriver.getCurrentDriver() instanceof IOSDriver) {	
		}
	}
	
	@AndroidFindBy(accessibility = "Quick add")
	@iOSXCUITFindBy(accessibility = "Quick add")
	private WebElement quickAdd;
	
	@AndroidFindBy(accessibility = "Add")
	@iOSXCUITFindBy(accessibility = "Add")
	private WebElement addBtn;
	
	public void waitForProjectPageLoad() {
		waitForEl(projectName);
	}
	
	public void createTask(String taskNameByUser) {
		quickAdd.click();
		waitNclick(taskName);
		waitNtype(taskName, taskNameByUser);
		addBtn.click();
		back();
	}
}
