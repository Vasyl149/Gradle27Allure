package page.login;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import page.AbstractPageObject;

import static config.ConfigManager.conf;

public class LoginPage extends AbstractPageObject {
    @FindBy(xpath = "//input[@name='login']")
    private WebElement email;

    @FindBy(css = "input[name='password']")
    private WebElement password;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement continueButton;



    @Step("Enter login and password")
    public void setCredentials(){
        this.email.sendKeys(conf().login());
        this.password.sendKeys(conf().password());


    }

    @Step("Click Login button")
    public void clickContinue(){
        continueButton.click();
    }
}
