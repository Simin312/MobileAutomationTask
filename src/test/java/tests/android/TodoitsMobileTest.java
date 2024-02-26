package tests.android;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import restAPI.Todoits;

public class TodoitsMobileTest {
	private String ActiveTasksJsonResponse;
	private String ProjectInfoJsonResponse;
	Todoits todoits;
	
	@BeforeClass
	public void setup() {
		todoits = new Todoits();
	}
	
	//@Test(priority = 1)
	public void createTestProject() {
		// create project from API
		todoits.AddProject("Create Project From API 2");
		ProjectInfoJsonResponse = todoits.getProjectInfoJsonResponse();
		
		// go to phone to assert
		
		
	}
	@Test(priority = 2)
	public void createTask() {
		// create task from android <- the task name
		
		// call API to get all active task
		//todoits.getActiveTasksJsonResponse();
		// get the Json Responce 
		todoits.GetAllActiveTask();
		ActiveTasksJsonResponse = todoits.getActiveTasksJsonResponse();
		
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
