package steps;

import Constants.EndPoints;
import DomainObject.RegisterDetails;
import factory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.RegistrationPage;

import java.util.List;
import java.util.Map;


public class RegistrationSteps {
    protected WebDriver driver;
    protected RegistrationPage registration;
    private String registeredUsername;
    private String actualMessage;
    @Given("I am on the registration page")
    public void i_am_on_the_askomdch_home_page() {
        driver = DriverFactory.initializeDriver(System.getProperty("browser","chrome"));
        registration = new RegistrationPage(driver);
        registration.load(EndPoints.ACCOUNT.url);
    }
    @When("I enter valid details:")
    public void navigate_to_account_page(DataTable dataTable) {
        List<Map<String, String>> rows = dataTable.asMaps(String.class, String.class);
        Map<String, String> data = rows.get(0);

        registeredUsername = data.get("userName");
        RegisterDetails customer = new RegisterDetails(
                registeredUsername,
                data.get("email"),
                data.get("password")
        );
        registration.registerCustomer(customer);
    }

    @And("I click on register button")
    public void iClickOnRegisterButton() {
        registration.clickRegisterButton();
    }

    @Then("I should be redirected to the dashboard")
    public void iShouldBeRedirectedToTheDashboard() {
        System.out.println(registration.isDashboardDisplayed());
    }

    @And("I see welcome message contains my username")
    public void iSeeWelcomeMessageContainsMyUsername() {
        String actualWelcomeMessage = registration.getWelcomeMessage();
        Assert.assertTrue("Welcome message did not contain username",
                actualWelcomeMessage.contains(registeredUsername));
    }
}
