package tests.android;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.BrowsePage;
import pages.GooglePermissionPage;
import pages.HomePage;
import restAPI.TodoitsAPI;

public class TodoitsMobileTest extends BaseTest {
	private String ActiveTasksJsonResponse;
	private String ProjectInfoJsonResponse;
	HomePage homePage;
	BrowsePage browsePage;
	TodoitsAPI todoitsAPI;
	GooglePermissionPage googlePermissionPage;
	
	@BeforeClass
	public void setup() {
		homePage = new HomePage();
		browsePage = new BrowsePage();
		todoitsAPI = new TodoitsAPI();
		googlePermissionPage = new GooglePermissionPage();
	}
	
	@Test
	public void createTestProject() throws InterruptedException {
		// create project from API
		String projectName = "Create Project From API";
		todoitsAPI.AddProject(projectName);
		ProjectInfoJsonResponse = todoitsAPI.getProjectInfoJsonResponse();
		
		// go to phone to assert
		googlePermissionPage.signinForTodoist();
		Assert.assertTrue(homePage.waitForMoreOption());
		homePage.navigateToBrowse();
		Thread.sleep(2000);
		Assert.assertEquals(browsePage.getProjectName(), projectName);
	}
	
	//@Test(priority = 2)
	public void createTask() {
		// create task from android <- the task name
		
		// call API to get all active task
		//todoits.getActiveTasksJsonResponse();
		// get the Json Responce 
		todoitsAPI.GetAllActiveTask();
		ActiveTasksJsonResponse = todoitsAPI.getActiveTasksJsonResponse();
		
		// validate the task name created by Android
		
		// test
		System.out.println("Project from class varaible: "+ ProjectInfoJsonResponse);
		System.out.println("Active Task: "+ActiveTasksJsonResponse);
	}
	
	public void ReopenTask() {
		// Create Task from mobile
		// get the task Id
		// complete task from mobile
		// reopen Task from API
		// verify task in your project
	}
	
	
	
}
