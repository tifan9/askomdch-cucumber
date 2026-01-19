package steps;

import Constants.EndPoints;
import DomainObject.LoginDetails;
import factory.DriverFactory;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;

import static org.junit.Assert.assertTrue;

public class LoginSteps {
    protected WebDriver driver;
    protected LoginPage login;
    private String actualMessage;

    @Given("I am on the login page")
    public void i_am_on_the_askomdch_home_page() {
        driver = DriverFactory.initializeDriver(System.getProperty("browser","chrome"));
        login = new LoginPage(driver);
        login.load(EndPoints.ACCOUNT.url);
    }

    @When("I login with username {string} and password {string}")
    public void login(String username, String password) {
        login.Login(new LoginDetails(username, password));
    }

    @And("I click on login button")
    public void iClickOnLoginButton() {
        login.clickLoginBtn();
        actualMessage = login.getWelcomingMessage();
    }

    @Then("I should see a welcome message for {string} on Dashboard")
    public void i_should_see_a_welcome_message_for(String username) {
        assertTrue("Login message did not contain username",
                actualMessage.contains(username));
    }


}
