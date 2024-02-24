package base;

import java.io.IOException;
import java.net.MalformedURLException;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import bsh.util.Util;
import driver.AppDriver;
import driver.AppFactory;

public class BaseTest {

	@BeforeClass
    public void launchApp() throws MalformedURLException {
        System.out.println("before method");
        AppFactory.launchApp();
        //base.AppiumServer.start();
    }


    @BeforeSuite
    public void serverStart(){
        System.out.println("before suite");
        base.AppiumServer.start();
    }

    @AfterSuite
    public void serverStop(){
        base.AppiumServer.stop();
    }
}
