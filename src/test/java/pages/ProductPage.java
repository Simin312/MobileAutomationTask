// For MYDEMOAPP
package pages;

import org.openqa.selenium.By;

import base.Util;
import driver.AppDriver;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

public class ProductPage extends BasePage{
	/* //android.widget.TextView[@content-desc="store item text"]
	 * */
	
	//@AndroidFindBy
	By productPage = AppiumBy.accessibilityId("container header");
	By itemNames;
	// 	sort button
	private By sortByOption = AppiumBy.accessibilityId("sort button");
	private By nameAsc = AppiumBy.accessibilityId("nameAsc");
	private By nameDesc = AppiumBy.accessibilityId("nameDesc");
	private By priceAsc = AppiumBy.accessibilityId("priceAsc");
	private By priceDesc= AppiumBy.accessibilityId("priceDesc");
	
	private By first_itemName; // (//android.widget.TextView[@content-desc=\"store item text\"])[1]
	private By first_itemPrice; // (//android.widget.TextView[@content-desc="store item price"])[1]
	
	public ProductPage() {
		if(AppDriver.getCurrentDriver() instanceof AndroidDriver) {
			//productPage = AppiumBy.accessibilityId("container header");
			itemNames = AppiumBy.xpath("//android.widget.TextView[@content-desc=\"store item text\"]");
			first_itemName = AppiumBy.xpath("(//android.widget.TextView[@content-desc=\"store item text\"])[1]");
			first_itemPrice = AppiumBy.xpath("(//android.widget.TextView[@content-desc=\"store item price\"])[1]");
			
		}else if(AppDriver.getCurrentDriver() instanceof IOSDriver) {
			//productPage = AppiumBy.accessibilityId("container header");
		}
	}

	public boolean waitForProductText() {
		return waitForEl(productPage).isDisplayed();
	}
	
	public String getFirstProductName() {
		return getText(first_itemName);
	}
	
	public String getFirstProductPrice() {
		return getText(first_itemPrice);
	}
	
	public int getItemCount() throws InterruptedException {
		int count = Util.getItems(itemNames).size();
		System.out.println(count);
		Util.scrollToTop();
		return count;
	}
	
	public void sortBy() {
		waitNclick(sortByOption);
		waitNclick(nameAsc);
	}
}
