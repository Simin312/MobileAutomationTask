package tests.android;


import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.BaseTest;
import base.JsonUtils;
import pages.BrowsePage;
import pages.GooglePermissionPage;
import pages.HomePage;
import pages.ProjectPage;
import restAPI.TodoitsAPI;

public class TodoitsMobileTest extends BaseTest {
	private String ActiveTasksJsonResponse;
	private String ProjectInfoJsonResponse;
	
	HomePage homePage;
	BrowsePage browsePage;
	TodoitsAPI todoitsAPI;
	GooglePermissionPage googlePermissionPage;
	JsonUtils jsonUtils;
	ProjectPage projectPage;
	
	private String projectName = "Create Project From API";
	private String taskContent = "Created Task From Mobile";
	
	@BeforeClass
	public void setup() {
		homePage = new HomePage();
		browsePage = new BrowsePage();
		todoitsAPI = new TodoitsAPI();
		googlePermissionPage = new GooglePermissionPage();
		jsonUtils = new JsonUtils();
		projectPage = new ProjectPage();
	}
	
	@Test(priority = 1)
	public void createTestProject() throws InterruptedException {
		// create project from API
		todoitsAPI.AddProject(projectName);
		ProjectInfoJsonResponse = todoitsAPI.getProjectInfoJsonResponse();
		
		// go to phone to assert
		googlePermissionPage.signinForTodoist();
		Assert.assertTrue(homePage.waitForMoreOption());
		homePage.navigateToBrowse();
		Thread.sleep(2000);
		Assert.assertEquals(browsePage.getProjectName(), projectName);
	}
	
	@Test(priority = 2)
	public void createTask() throws InterruptedException {
		// create task from android 
		//googlePermissionPage.signinForTodoist();
		//Assert.assertTrue(homePage.waitForMoreOption());
		//homePage.navigateToBrowse();
		browsePage.navigateToProject();
		projectPage.waitForProjectPageLoad();
		projectPage.createTask(taskContent);
		
		// get the Json Responce from API and check the taskContent is appear. 
		Thread.sleep(2000);
		todoitsAPI.GetAllActiveTask();
		ActiveTasksJsonResponse = todoitsAPI.getActiveTasksJsonResponse();
		Assert.assertTrue(jsonUtils.isTaskPresent(ActiveTasksJsonResponse, "content", taskContent));
	}
	
	public void ReopenTask() {
		// Create Task from mobile
		// get the task Id
		
		// complete task from mobile
		
		
		// reopen Task from API
		// verify task in your project
	}
	
	
	
}
