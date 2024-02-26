package tests.android;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.BrowsePage;
import pages.GooglePermissionPage;
import pages.HomePage;


public class TodoitsCreateProjectTest extends BaseTest{
	
	BrowsePage browsePage;
	HomePage homePage;
	GooglePermissionPage googlePermissionPage;
	
	@BeforeClass
	public void setup() {
		browsePage = new BrowsePage();
		homePage = new HomePage();
		googlePermissionPage = new GooglePermissionPage();
	}
	
	@Test
	public void createProjectTest() {
		googlePermissionPage.signinForTodoist();
		//Home Page
		Assert.assertTrue(homePage.waitForMoreOption());
		homePage.navigateToBrowse();
		
		browsePage.addProject();
		Assert.assertEquals(browsePage.getProjectName(), "Create Project");
	}
	
	
	
	
	

}
