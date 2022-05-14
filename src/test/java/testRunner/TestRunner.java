package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)

@CucumberOptions(
    features = "D:\\eclipseworkspaceAug2018\\RestAssuredAPIAutomationMay62022\\src\\test\\java\\Features",
    glue = {"step_def"},
    plugin={"pretty","html:target/report.html", "json:json_output/cucumber.json", "junit:junit_xml/cucumber.xml"},
    dryRun=false, //mapping between feature & stepdefinition is proper or not
    monochrome=true,//display the console output in a proper readable format
    publish = true,
    stepNotifications=true
    //tags = "@smoke"		
    	)	
public class TestRunner {
    	
}
