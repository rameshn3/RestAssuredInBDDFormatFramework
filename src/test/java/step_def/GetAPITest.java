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

public class GetAPITest extends TestBase{

Response resp;
	
@Given("^provide valid endpoint to fetch all users$")
public void provide_valid_endpoint_to_fetch_all_users() throws Throwable {
   //setting the base Url
	RestAssured.baseURI=readPropertyValue("baseUrl");
   //setting the endpoint url
	RestAssured.basePath=readPropertyValue("getAllUserEndPoint");
}

@When("^the request is send to the server$")
public void the_request_is_send_to_the_server() throws Throwable {
   resp=RestAssured.given().header("Accept","application/json").
		   header("Content-type", "application/json").
		   queryParam("page", 2).
		   when().
		   get().
		   then().
		   contentType("application/json").
		   extract().response();
}

@Then("^validate the response statuscode 200$")
public void validate_the_response_statuscode_200() throws Throwable {
   int respCode=resp.getStatusCode();
   Assertions.assertEquals(respCode, 200);
}

@When("^the request is send to the server with page number as \"([^\"]*)\"$")
public void the_request_is_send_to_the_server_with_page_number_as_something(int pageNumber) throws Throwable {
	resp=RestAssured.given().header("Accept","application/json").
			   header("Content-type", "application/json").
			   queryParam("page", pageNumber).
			   when().
			   get().
			   then().
			   contentType("application/json").
			   extract().response();
}

@Then("^validate the response of first user record having email as \"([^\"]*)\"$")
public void validate_the_response_of_first_user_record_having_email_as_something(String emailid) throws Throwable {
   //extracting the response body field value
	String email=resp.path("data[0].email");
	Assertions.assertEquals(email, emailid);
}

@Then("^validate response statuscode (.+)$")
public void validate_response_statuscode(int respstatuscode) throws Throwable {
	int respCode=resp.getStatusCode();
	 Assertions.assertEquals(respCode, respstatuscode); 
}

@Given("^provide valid endpoint to fetch the single user$")
public void provide_valid_endpoint_to_fetch_the_single_user() throws Throwable {
   //set the base url
	RestAssured.baseURI=readPropertyValue("baseUrl");
	//set the basepath
	RestAssured.basePath=readPropertyValue("getSingleUserEndPoint");
}

@When("^the request is send to the server to fetch single user$")
public void the_request_is_send_to_the_server_to_fetch_single_user() throws Throwable {
  resp=RestAssured.given().header("Accept","application/json").
		   header("Content-type", "application/json").
		   when().
		   get("/2").
		   then().
		   contentType("application/json").
		   extract().response();
}

@Then("^validate the response body fields$")
public void validate_the_response_body_fields(DataTable values) throws Throwable {
   List<List<String>>ls=values.asLists();
	
	int id=resp.path("data.id");
   System.out.println("id value is:"+id);
   Assertions.assertEquals(Integer.parseInt(ls.get(0).get(0)), id);
   //fetch the email
   String emailVal=resp.path("data.email");
   System.out.println("email value is:"+emailVal);
   Assertions.assertEquals(ls.get(0).get(1), emailVal);
 //fetch the first name
   String firstNameVal=resp.path("data.first_name");
   System.out.println("firstName value is:"+firstNameVal);
   Assertions.assertEquals(ls.get(0).get(2), firstNameVal);
   
 //fetch the lastname
   String lastnameVal=resp.path("data.last_name");
   System.out.println("lastname value is:"+lastnameVal);
   Assertions.assertEquals(ls.get(0).get(3), lastnameVal);
}

@Given("^provide valid endpoint to fetch the single userNotFound$")
public void provide_valid_endpoint_to_fetch_the_single_usernotfound() throws Throwable {
	//set the base url
		RestAssured.baseURI=readPropertyValue("baseUrl");
		//set the basepath
		RestAssured.basePath=readPropertyValue("getSingleUserNotFoundEndPoint");
}

@When("^the request is send to the server to fetch single user not found$")
public void the_request_is_send_to_the_server_to_fetch_single_user_not_found() throws Throwable {
	 resp=RestAssured.given().header("Accept","application/json").
			   header("Content-type", "application/json").
			   when().
			   get().
			   then().
			   contentType("application/json").
			   extract().response();  
}

@Then("^validate the response statuscode$")
public void validate_the_response_statuscode(DataTable exrespcode) throws Throwable {
 	int respCode=resp.getStatusCode();
 List<String>ls=exrespcode.asList();
 int expval=Integer.parseInt(ls.get(0));
	 Assertions.assertEquals(respCode,expval); 
}

}



