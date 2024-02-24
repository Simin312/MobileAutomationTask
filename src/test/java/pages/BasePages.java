package pages;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import driver.AppDriver;
//import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.SupportsContextSwitching;

public class BasePages {
	
	WebDriverWait wait = new WebDriverWait(AppDriver.getCurrentDriver(), Duration.ofSeconds(30));

	protected WebElement waitForEl(By byLocator) {
		return wait.until(ExpectedConditions.presenceOfElementLocated(byLocator));
	}
	
	protected WebElement getEl(By byLocator) {
		return AppDriver.getCurrentDriver().findElement(byLocator);
	}
	
	protected List<WebElement> getEls(By byLocator){
		return AppDriver.getCurrentDriver().findElements(byLocator);
	}
	
	protected void click(By byLocator) {
		getEl(byLocator).click();
	}
	
	protected void type(By byLocator, String text) {
		getEl(byLocator).sendKeys(text);
	}
	
	protected void waitNtype(By byLocator, String text) {
		waitForEl(byLocator).sendKeys(text);
	}
	
	protected void waitNClick(By byLocator) {
		waitForEl(byLocator).click();
	}
	
	protected int size(By byLocator) {
		return getEls(byLocator).size();
	}
	
	protected int size(List<WebElement> els) {
		return els.size();
	}
	
	protected String getText(By byLocator) {
		return waitForEl(byLocator).getText();
	}
	
	protected String getAttribute(By byLocator, String attr) {
		return waitForEl(byLocator).getAttribute(attr);
	}
	
	protected boolean isListItemContain(List<WebElement> items, String text) {
		boolean flag = false;
		
		for(WebElement el: items) {
			if (el.getText().contains(text)) {
				flag = true;
				break;
			}
		}
		return flag;
	}
	
	protected boolean isTextMatches(WebElement el, String text) {
		return el.getText().equalsIgnoreCase(text);
	}
	
	protected boolean isTextContains(WebElement el, String text) {
		return el.getText().contains(text);
	}
	/*
	 * FindBy(id = "some") -> using WebElement
	 * private WebElement login;
	 * is TextContains(login,"login")
	 * 
	 * By login = by.id(login)  -> using byLocator
	 * isTextContains(getEl(login),"login")
	 */
	
	protected Set<String> getContexts() {
		return ((SupportsContextSwitching)AppDriver.getCurrentDriver()).getContextHandles();
	}
	
	protected String getContext() {
		return ((SupportsContextSwitching)AppDriver.getCurrentDriver()).getContext();
	}
	
	private Select getDropDownElement(By byLocator) {
        return new Select(AppDriver.getCurrentDriver().findElement(byLocator));
    }
    private Select getDropDownElement(WebElement el) {
        return new Select(el);
    }

    public void selectDropDownByOption(WebElement el, String option){
        getDropDownElement(el).selectByVisibleText(option);
    }

    protected List<WebElement> getDropDownOptions(WebElement el) {
        return getDropDownElement(el).getOptions();
    }

    protected List<WebElement> getDropDownAllSelectedOptions(WebElement el) {
        return getDropDownElement(el).getAllSelectedOptions();
    }

    protected WebElement getDropDownSelectedOption(WebElement el) {
        return getDropDownElement(el).getFirstSelectedOption();
    }

    protected boolean isDropDownItemscontain(WebElement element, String text){
        boolean flag = false;
        List<WebElement> els = getDropDownElement(element).getOptions();
        for(WebElement el: els){
            if(el.getText().contains(text)){
                flag = true;
                break;
            }
        }
        return flag;
    }
}
