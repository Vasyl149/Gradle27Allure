package page.common;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import page.AbstractPageObject;

public class Header extends AbstractPageObject {
    @FindBy(css = ".login-button__control")
    private WebElement controlButton;

    @FindBy(css = "#login__logout")
    private WebElement logoutButton;

    @Step
    public void controlButton(){
        controlButton.click();
    }

    @Step
    public void logoutButton(){
        logoutButton.click();
    }

}
