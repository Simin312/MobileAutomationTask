package tests.android;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import restAPI.Todoits;

public class TodoitsMobileTest {
	private String ActiveTasksJsonResponse;
	Todoits todoits;
	
	@BeforeClass
	public void setup() {
		todoits = new Todoits();
	}
	
	@Test
	public void createTestProject() {
		// create project from API
		todoits.AddProject("Create Project From API");
		// go to phone to assert
		
	}
	
	public void createTask() {
		// create task from android <- the task name
		
		// call API to get all active task
		todoits.getActiveTasksJsonResponse();
		// get the Json Responce 
		ActiveTasksJsonResponse = todoits.getActiveTasksJsonResponse();
		
		// validate the task name created by Android
	}
	
	
}
