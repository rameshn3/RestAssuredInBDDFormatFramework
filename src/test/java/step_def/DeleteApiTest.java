package step_def;

import java.util.List;

import org.junit.jupiter.api.Assertions;

import com.qa.api.rest.base.TestBase;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DeleteApiTest extends TestBase{
	
Response resp;
@Given("^provide valid endpoint to delete the user$")
public void provide_valid_endpoint_to_delete_the_user() throws Throwable {
    //set base url
	RestAssured.baseURI=readPropertyValue("baseUrl");
	//set basepath
	RestAssured.basePath=readPropertyValue("getSingleUserEndPoint");
}

@When("^the request is send to the server delete the user$")
public void the_request_is_send_to_the_server_delete_the_user() throws Throwable {
   resp=RestAssured.given().header("Accept", "application/json").
   		header("Content-Type","application/json").
   		when().
   		delete("/2").then().extract().response();
}

@Then("^validate delete user response statuscode$")
public void validate_delete_user_response_statuscode(DataTable table) throws Throwable {
		  int respCode=resp.getStatusCode();
		  System.out.println("Update Api Status code is:"+respCode);
		  //implement DataTable concept
		  List<String>ls=table.asList();
		  //convert String object into int
		  int expRespCode=Integer.parseInt(ls.get(0));
		  Assertions.assertEquals(expRespCode, respCode);
}

	
}
