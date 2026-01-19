package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AccountPage {
    private WebDriver driver;
    private WebDriverWait wait;
    public AccountPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    // Login
    private By usernameField = By.id("username");
    private By passwordField = By.id("password");
    private By submitBtn=By.name("login");
    private By statusMessage=By.cssSelector("div.woocommerce-MyAccount-content p:first-of-type");

    // registration
    private By regUsernameField = By.id("reg_username");
    private By regEmailField = By.id("reg_email");
    private By regPasswordField = By.id("reg_password");
    private By regSubmitBtn = By.name("register");
    private By logoutLink = By.linkText("Log out");
    private By loginBtn = By.name("login");
    public String login(String username, String password){
        driver.findElement(usernameField).sendKeys(username);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(submitBtn).click();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(driver1 -> driver.findElement(statusMessage).isDisplayed());
        return driver.findElement(statusMessage).getText();
    }
    public String register(String username, String email, String password){
        driver.findElement(regUsernameField).sendKeys(username);
        driver.findElement(regEmailField).sendKeys(email);
        driver.findElement(regPasswordField).sendKeys(password);
        driver.findElement(regSubmitBtn).click();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(driver1 -> driver.findElement(statusMessage).isDisplayed());
        return driver.findElement(statusMessage).getText();
    }
    public boolean logout() {
        driver.findElement(logoutLink).click();
        wait.until(driver1 -> driver.findElement(loginBtn).isDisplayed());
        return driver.findElement(loginBtn).isDisplayed();
    }
    public boolean isLoggedIn(String username) {
        return driver.findElement(statusMessage)
                .getText()
                .contains(username);
    }


}