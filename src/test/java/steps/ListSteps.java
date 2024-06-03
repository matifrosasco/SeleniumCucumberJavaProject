package steps;

import java.util.List;
import io.cucumber.java.en.*;
import pages. ListPage;


public class ListSteps {
    ListPage list = new ListPage();

    @Given("^I navigate to the list pages")
    public void navigateToListPage() {
            list.navigateToListPage();
    }

    @When("^I search (.+) in the list$")
    public void searchTheList(String state) throws InterruptedException {
            list.enterSearchCriteria(state);
    }

    @Then ("^I can find (.+) in the list$") //(.+) eso significa que ahi va un argumento String
    public void theCityIsThere(String city) {
            List<String> lista = list.getAllSearchResults();
            boolean textIsThere = lista.contains(city);

            if (textIsThere) {
                System.out.println("The text is on the list: PASSED.");
            }else{
                throw new Error("The text is not on the list: FAILED!");
            }
        }
}


