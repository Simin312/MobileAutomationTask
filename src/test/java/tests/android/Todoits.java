package tests.android;

import static org.hamcrest.Matchers.equalTo;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class Todoits {
private String bearerToken = "1559e795da7f06f992467ea70838d8174880d0d7";
private String jsonResponse;	
	
	//Add New Project
	//@Test
	public void AddProject() {
		baseURI = "https://api.todoist.com/rest/v2/";
		JSONObject request = buildProjectRequest("name", "Create Project From API 8");
	
		try {
			jsonResponse = given().
			        headers(
			            "Authorization", "Bearer " + bearerToken, "Content-Type", ContentType.JSON, "Accept", ContentType.JSON).
			        	body(request.toJSONString()).
			        when().
			        	post("/projects").
					then().
						statusCode(200).
						log().all().
						extract().asString();
			
			System.out.println(jsonResponse);
		}catch (Exception e) {
            System.err.println("Exception during AddProject: " + e.getMessage());
            e.printStackTrace();
        }
	}
	
	private JSONObject buildProjectRequest(String Key, String Value) {
	    JSONObject request = new JSONObject();
	    request.put(Key, Value);
	    return request;
	}
	
	
	@Test
	public void CreateTask() {
		baseURI = "https://api.todoist.com/rest/v2/";
		//JSONObject request = buildProjectRequest("project_id", "2329225985");
		try {
			given().
			headers(
	            "Authorization", "Bearer " + bearerToken, "Content-Type", ContentType.JSON, "Accept", ContentType.JSON).
				//body(request.toJSONString()).
        	when().
	        	get("/tasks").
			then().
				statusCode(200).
				log().all().
				extract().response();

			
		}catch (Exception e) {
			System.err.println("Exception during AddProject: " + e.getMessage());
			e.printStackTrace();
		}
	
		
	}
	
	

	
	

	
	public String getJsonResponse() {
        return jsonResponse;
    }

}
