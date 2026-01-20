package steps;

import Constants.EndPoints;
import DomainObject.ProductObj;
import factory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.CartPage;
import pages.StorePage;

public class CartStepDefinitions {
    protected WebDriver driver;
    protected StorePage storePage;
    private CartPage cartPage;
    @Given("I'm on the Store Page")
    public void iMOnTheStorePage() {
        driver = DriverFactory.initializeDriver(System.getProperty("browser","chrome"));
        storePage = new StorePage(driver);
        storePage.load(EndPoints.STORE.url);
    }
    @When("I add a {string} to the cart")
    public void iAddABlueShoesToTheCart(String productName) {
        storePage.addToCart(productName);
    }
    @Then("I should see {int} {string} in the cart")
    public void iShouldSeeBlueShoesInTheCart(int quantity, String productName) {
        CartPage cartPage = new CartPage(driver);
        String names = cartPage.getProductName();
        Assert.assertEquals(productName, names);
        Assert.assertEquals(quantity, cartPage.getProductQuantity());
    }

}
