package steps;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;

import io.cucumber.java.en.*;
import pages.GooglePage;


public class GoogleSteps {

    GooglePage google = new GooglePage();

    @Given("^I am on the Google search page$") //esto tiene que ser exactamente igual que el feature
    public void navigateToGoogle(){
        google.navigateToGoogle();
    }

    @When("^I enter a search criteria$")
    public void enterSearchCriteria(){
        google.enterSearchCreiteria("google");
    }

    @And("^click on the search button$")
    public void clickSearchButton(){
        google.clickGoogleSearch();
    }

    @Then("^the results match the criteria$")
    public void validateResults(){
        Assert.assertEquals("Texto que esperamos",  google.firstResult());
    }

}
