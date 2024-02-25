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
	/*  Username input field
	 *  Password input field 
	 *  Login button
	 * username is required error message xpath
	 *  //android.widget.TextView[@text="Username is required"]  
	 * password is required error message xpath
	 * 	//android.widget.TextView[@text="Password is required"] 
	 * username or password is wrong error xpath
	 * 	//android.widget.TextView[@text="Provided credentials do not match any user in this service."]
	 *  android xpath "/" type 
	 * */
	private By userName;
	private By userNameErrorText;
	private By passwordErrorText;
	private By credentialsErrorText;
	
	public LoginPage(){
		if(AppDriver.getCurrentDriver() instanceof AndroidDriver) {
			userName = AppiumBy.accessibilityId("Username input field");
			userNameErrorText = By.xpath("//android.widget.TextView[@text=\"Username is required\"] ");
			passwordErrorText =By.xpath("//android.widget.TextView[@text=\"Password is required\"] ");
			credentialsErrorText =By.xpath("//android.widget.TextView[@text=\"Provided credentials do not match any user in this service.\"]");
		}else if(AppDriver.getCurrentDriver() instanceof IOSDriver) {
			userName = AppiumBy.accessibilityId("");
		}
	}
	
	@AndroidFindBy(accessibility = "Password input field")
	@iOSXCUITFindBy(accessibility = "Password input field")
	private WebElement Password;
	
	@AndroidFindBy(accessibility = "Login button")
	@iOSXCUITFindBy(accessibility = "Login button")
	private WebElement btnLogin;
	
	MenuPage menuPage = new MenuPage();
	
	public void login(String username, String password) {
		//menuPage.navitageToLogin();
		waitNtype(userName, username);
		Password.clear();
		Password.sendKeys(password);
		btnLogin.click();
	}
	
	public String getUserNameErrorText() {
		return getText(userNameErrorText);
	}
	
	public String getPasswordErrorText() {
		return getText(passwordErrorText);
	}
	
	public String getCredentialsErrorText() {
		return getText(credentialsErrorText);
	}
}
