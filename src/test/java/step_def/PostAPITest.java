package step_def;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;

import com.qa.api.rest.base.TestBase;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class PostAPITest extends TestBase{

Response resp;
JSONObject jsonObj=new JSONObject();
@Given("^provide valid endpoint to create user$")
public void provide_valid_endpoint_to_create_user() throws Throwable {
    //set the baseUrl
	RestAssured.baseURI=readPropertyValue("baseUrl");
	//set the base path
	RestAssured.basePath=readPropertyValue("getAllUserEndPoint");
	
}

@When("^the request is send to the server with requestbody$")
public void the_request_is_send_to_the_server_with_requestbody() throws Throwable {
	
	 jsonObj.put("name", "CH Ramesh");
	 jsonObj.put("job", "AutomationTestLead"); 
	resp=RestAssured.given().header("Accept", "application/json").
    		header("Content-Type","application/json").
    		body(jsonObj.toString()).
    		when().
    		post().
    		then().
    		extract().response();
 		   
 		   
}

@Then("^validate create user response statuscode$")
public void validate_create_user_response_statuscode(DataTable code) throws Throwable {
   int respCode=resp.getStatusCode();
  System.out.println("session id is:"+resp.getSessionId());
  System.out.println("statusline:"+resp.getStatusLine());
  System.out.println("response time:"+resp.getTime());
   Assertions.assertEquals(Integer.parseInt(code.asList().get(0)), respCode);
}

@Then("^validate the responsebody fields$")
public void validate_the_responsebody_fields() throws Throwable {
    String nameval=resp.path("name");
    System.out.println("name value is:"+nameval);
    Assertions.assertEquals(jsonObj.get("name"), nameval);
    String jobval=resp.path("job");
    Assertions.assertEquals(jsonObj.get("job"), jobval);
}
@Given("^provide valid endpoint to create users$")
public void provide_valid_endpoint_to_create_users() throws Throwable {
    //set base Url
	RestAssured.baseURI=readPropertyValue("baseUrl");
	//set the base path
	RestAssured.basePath=readPropertyValue("getAllUserEndPoint");
	
}
@When("^the request is send to the server with requestbody as \"([^\"]*)\" and \"([^\"]*)\"$")
public void the_request_is_send_to_the_server_with_requestbody_as(String name, String job) throws Throwable {
	 jsonObj.put("name", name);
	 jsonObj.put("job", job); 
	resp=RestAssured.given().header("Accept", "application/json").
    		header("Content-Type","application/json").
    		body(jsonObj.toString()).
    		when().
    		post().
    		then().
    		extract().response();

}




}
