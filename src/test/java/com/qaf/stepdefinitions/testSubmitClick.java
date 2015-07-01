package test.java.com.qaf.stepdefinitions;

import org.testng.Assert;

import test.java.com.qaf.utils.WebConnector;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class testSubmitClick {
	
	WebConnector tests = new WebConnector();
	@Given("^I go to \"([^\"]*)\" on \"([^\"]*)\"$")
	public void gotoGmail(String url,String browser){
		
		System.out.println("I am going to -->"+ url);
		tests.openBrowser(browser);
		tests.navigate(url);
	}
	@And("I click on \"([^\"]*)\"")
		public void clickSignInLink(String object){
			tests.click(object);
		}
	
	
	@And ("I click on \"([^\"]*)\"")
	public void clickonNextButton(String object){
		tests.click(object);

	}
	@Then("I see error \"([^\"]*)\" as \"([^\"]*)\"")
	public void loginSuccessful(String objectname,String expectedText){
		
		String actualText = tests.getElementText(objectname);
		
		if(actualText.equals(expectedText)){
			System.out.println("Success");
			
		}else{
			actualText = "failure";
			Assert.assertEquals(actualText, expectedText);

			
		}
	}
}
