package restAPI;

import static org.hamcrest.Matchers.equalTo;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class TodoitsAPI {
private String bearerToken = "1559e795da7f06f992467ea70838d8174880d0d7";
private String ProjectInfoJsonResponse;	
private String ActiveTasksJsonResponse;
	
	//Add New Project
	public void AddProject(String projectName) {
		baseURI = "https://api.todoist.com/rest/v2/";
		JSONObject request = buildProjectRequest("name", projectName);
		ProjectInfoJsonResponse = given().
			        headers(
			            "Authorization", "Bearer " + bearerToken, "Content-Type", ContentType.JSON, "Accept", ContentType.JSON).
			        	body(request.toJSONString()).
			        when().
			        	post("/projects").
					then().
						statusCode(200).
						log().all().
						extract().asString();
			//System.out.println(jsonResponse);
	}
	
	private JSONObject buildProjectRequest(String Key, String Value) {
	    JSONObject request = new JSONObject();
	    request.put(Key, Value);
	    return request;
	}
	
	public void GetAllActiveTask() {
		baseURI = "https://api.todoist.com/rest/v2/";
		//JSONObject request = buildProjectRequest("project_id", "2329225985");
		ActiveTasksJsonResponse = given().
			headers(
	            "Authorization", "Bearer " + bearerToken, "Content-Type", ContentType.JSON, "Accept", ContentType.JSON).
				//body(request.toJSONString()).
        	when().
	        	get("/tasks").
			then().
				statusCode(200).
				log().all().
				extract().asString();
	}
	
	public void ReopenTask(String taskId) {
		baseURI = "https://api.todoist.com/rest/v2/";
		given().
		headers(
            "Authorization", "Bearer " + bearerToken, "Content-Type", ContentType.JSON, "Accept", ContentType.JSON).
			//body(request.toJSONString()).
    	when().
        	post("/tasks/+taskId+/reopen").
		then().
			statusCode(204).
			log().all().
			extract().asString();
	}
	
	
	public String getProjectInfoJsonResponse() {
        return ProjectInfoJsonResponse;
    }
	
	public String getActiveTasksJsonResponse() {
        return ActiveTasksJsonResponse;
    }
	

}
