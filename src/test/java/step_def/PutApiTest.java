package step_def;

import java.util.List;

import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;

import com.qa.api.rest.base.TestBase;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class PutApiTest extends TestBase{

Response resp;
JSONObject jsonObj=new JSONObject();

@Given("^provide valid endpoint to update user$")
public void provide_valid_endpoint_to_update_user() throws Throwable {
	//set the baseUrl
		RestAssured.baseURI=readPropertyValue("baseUrl");
		//set the base path
		RestAssured.basePath=readPropertyValue("getAllUserEndPoint");
}

@When("^the request is send to the server with requestbody to update$")
public void the_request_is_send_to_the_server_with_requestbody_to_update() throws Throwable {
	 jsonObj.put("name", "Muniraja");
	 jsonObj.put("job", "Automation Architect"); 
	resp=RestAssured.given().header("Accept", "application/json").
    		header("Content-Type","application/json").
    		body(jsonObj.toString()).
    		when().
    		put("/2").
    		then().
    		extract().response();
}

@Then("^validate update user response statuscode$")
public void validate_update_user_response_statuscode(DataTable table) throws Throwable {
  int respCode=resp.getStatusCode();
  System.out.println("Update Api Status code is:"+respCode);
  //implement DataTable concept
  List<String>ls=table.asList();
  //convert String object into int
  int expRespCode=Integer.parseInt(ls.get(0));
  Assertions.assertEquals(expRespCode, respCode);
}

@Then("^validate the update responsebody fields$")
public void validate_the_update_responsebody_fields() throws Throwable {
    String respname=resp.path("name");
    System.out.println("resp name is:"+respname);
    Assertions.assertEquals(jsonObj.get("name"), respname);
    String respjob=resp.path("job");
    System.out.println("resp job is:"+respjob);
    Assertions.assertEquals(jsonObj.get("job"), respjob);
    String respupdateAt=resp.path("updatedAt");
    System.out.println("updated at:"+respupdateAt);
    
}
}
