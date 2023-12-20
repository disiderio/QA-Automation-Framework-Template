package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver givenDriver) {
        super(givenDriver);
    }

    @FindBy (css = "input[type='email']")
    WebElement emailField;
    //By emailField = By.cssSelector("input[type='email']");

    @FindBy (css = "input[type='password']")
    WebElement passwordField;
    //By passwordField = By.cssSelector("input[type='password']");

    @FindBy (css = "button[type='Submit']")
    WebElement submitBtnLocator;
    //By submitBtn = By.cssSelector("button[type='Submit']");

    public void provideEmail(String email) {
        emailField.sendKeys(email);
    }
    public void providePassword(String password) {
        passwordField.sendKeys(password);
    }
    public void clickSubmitBtn() {
        submitBtnLocator.click();
    }
    public void login() {
        provideEmail("demo@class.com");
        providePassword("te$t$tudent");
        clickSubmitBtn();
    }


}
