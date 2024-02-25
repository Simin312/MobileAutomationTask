package tests.android;

import static org.hamcrest.Matchers.equalTo;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class GetAndPostExamples {

	//@Test
	public void testGet() {
		baseURI = "https://reqres.in/api";
		given().
			get("/users?page=2").
		then().
			statusCode(200).
			body("data[4].first_name", equalTo("George")).
			body("data.first_name", hasItems("George","Rachel"));		
	}
	@Test
	public void testPost() {
//		Map<String, Object> map = new HashMap<String, Object>();	
//		map.put("name", "Chan");
//		map.put("job", "Teacher");	
//		System.out.println(map);

		JSONObject request = new JSONObject();
		
		request.put("name", "Chan");
		request.put("job", "Teacher");
		
		System.out.println(request.toJSONString());
		
		baseURI = "https://reqres.in/api";
		given().
			header("Content-Type", "application/json").
			contentType(ContentType.JSON). // send content Type send is JSON
			accept(ContentType.JSON). // respond type accept JSON
			body(request.toJSONString()).
		when().
			post("/user").
		then().
			statusCode(201).
			log().all();
	}
}
