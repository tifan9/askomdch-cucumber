package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;
    public HomePage(WebDriver driver){
        this.driver = driver;
    }
    private By accountLink = By.xpath("//*[@id=\"menu-item-1237\"]/a");
    // click method ✅
    private void clickElement(String element){
        driver.findElement(By.linkText(element)).click();
    }
    public AccountPage goToAccountPage(){
        driver.findElement(accountLink).click();
        return new AccountPage(driver);
    }
}
