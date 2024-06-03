package steps;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.GridPage;

public class GridTestSteps {

    GridPage grid = new GridPage();

    @Given("^I navigate to the static table$")
    public void navigateToGridPage(){
        grid.navigateToGrid();
    }

    @Then("^I can return the value I wanted$")
    public void returnValue(){
        String value = grid.getValueFromGrid(3, 2);

        System.out.println(value);
        Assert.assertEquals(value, "r: 2, c: 1");
    }

    @Then("^I can validate the table is displayed$")
    public void theTableIsThere(){
        Assert.assertTrue(grid.cellStatus(), "El elemento si esta siendo mostrado"); //True que si esta mostrando, assertFasle, verificarque no lo esta mostrando
    }


    
}
