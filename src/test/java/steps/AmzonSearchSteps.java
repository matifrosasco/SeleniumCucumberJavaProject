package steps;

import org.junit.Assert;

import io.cucumber.java.en.*;
import pages. AmazonSearchPage;

public class AmzonSearchSteps {
    
    AmazonSearchPage amazon = new AmazonSearchPage();

    @Given("^the user navigates to www.amazon.com$")
    public void navigateToAmazon(){
        amazon.navigateToAmazon();
    }

    @And("searches for (.+)$")
    public void enterSearchCriteria (String criteria) {
        amazon.enterSearchCriteria (criteria);
        amazon.clickSearch();
    }

    @And("^navigates to the page number (.+)$")
    public void navigateToSecondPage(String pageNumber) { 
        amazon.goToPage(pageNumber);
    }

    @And("selects the third item$")
    public void selectsThirdItem() {
        amazon.pick3rdItem();
    }

    @Then("^the user is able to add it to the cart$")
    public void itemCanBeAddedToTheCart() {
        amazon.addToCart();
        try{
            Assert.assertEquals("Agregado al carrito", amazon.addedToCartMessage()); 
                System.out.println("Se agregó correctamente");
    }   catch (AssertionError e) {
                System.out.println("No se agregó");
                throw e; // Re-lanzar la excepción si necesitas que la prueba falle
    }
       
        
    } 
}