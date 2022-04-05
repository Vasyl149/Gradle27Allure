package page.main;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import page.AbstractPageObject;

import static config.ConfigManager.conf;

public class DraftsPage extends AbstractPageObject {

    @FindBy (css = ".msglist__row")
    private WebElement firstDraft;

    @FindBy (xpath = "//button[@class='button primary send']")
    private WebElement sendButton;

    @FindBy (css = ".alert__buttons")
    private WebElement alertCloseButton;

    @FindBy (xpath = "//input[@name='toFieldInput']")
    private WebElement emailInputField;

    @FindBy (css = "div.sendmsg__ads-ready")
    private WebElement confirmMessage;

    @Step
    public void firstDraft(){
        firstDraft.click();
    }

    @Step
    public void sendButton(){
        sendButton.click();
    }

    @Step
    public void closeAlert(){
        alertCloseButton.click();
    }

    @Step
    public void fillEmailField(){
        emailInputField.click();
        emailInputField.sendKeys(conf().testemail());
    }

    @Step
    public WebElement confirmMessage(){
        return confirmMessage;
    }
}
