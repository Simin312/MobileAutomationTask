package base;

import java.net.MalformedURLException;

import org.testng.annotations.BeforeTest;

import driver.AppFactory;

public class BaseTest {

	@BeforeTest
	public static void launchApp() throws MalformedURLException {
		AppFactory.lauchApp();
	}
}
