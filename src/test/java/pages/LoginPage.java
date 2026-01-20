package pages;
import DomainObject.LoginDetails;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

    @FindBy(id = "username")
    private WebElement userNameFld;
    @FindBy(id = "password")
    private WebElement userPasswordFld;
    @FindBy(css = "button[value='Log in']")
    private WebElement loginBtn;
    @FindBy(linkText = "Dashboard")
    private WebElement dashboardLink;
    @FindBy(css = "div.woocommerce-MyAccount-content p")
    private WebElement welcomeMessage;


    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void Login(LoginDetails login){
        userNameFld.sendKeys(login.getUserName());
        userPasswordFld.sendKeys(login.getPassword());
    }
    public void clickLoginBtn(){
        loginBtn.click();
    }

    public boolean isDashboardDisplayed(){
        return dashboardLink.isDisplayed();
    }
    public String getWelcomingMessage(){
        return welcomeMessage.getText();
    }
}
