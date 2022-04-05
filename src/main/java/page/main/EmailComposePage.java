package page.main;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import driver.DriverManager;
import java.io.FileNotFoundException;
import page.AbstractPageObject;
import java.util.List;

import static config.ConfigManager.conf;

public class EmailComposePage extends AbstractPageObject {

    @FindBy(xpath = "//div[@aria-label='Bold']")
    private WebElement boldButton;

    @FindBy(xpath = "//div[@aria-label='Italic']")
    private WebElement italicButton;

    @FindBy(xpath = "//iframe[@frameborder='0']")
    private WebElement textArea;

    @FindBy(xpath ="//body[@id='tinymce']" )
    private WebElement textField;

    @FindBy(xpath = "//b[contains(text(), 'hello')]")
    private WebElement message;

    @FindBy(css = "div#mceu_27")
    private WebElement fontDropdown;

    @FindBy(xpath = "//div[@id='mceu_35-body']/div")
    private List<WebElement> fontList;

    @FindBy(css = "input.sendmsg__attachments-file-input")
    private WebElement fileInput;

    @Step
    public void boldButton() {
        boldButton.click();
    }
    @Step
    public void italicButton() {
        italicButton.click();
    }

    @Step
    public void switchToTextArea(){
        DriverManager.getDriver().switchTo().frame(textArea);
    }

    @Step
    public void switchToParentFrame(){
        DriverManager.getDriver().switchTo().parentFrame();
    }

    @Step
    public void fillTextField(){
        textField.sendKeys(conf().message());
    }

    @Step
    public String fontStyle(){
        return message.getCssValue("font-style");
    }

    @Step
    public String fontWeight(){
        return message.getCssValue("font-weight");
    }

    @Step
    public void fontDropdown(){
        fontDropdown.click();
    }

    @Step
    public List<WebElement> getFontList(){
        return fontList;
    }

    public void fileInput() throws FileNotFoundException {
       fileInput.sendKeys(conf().testFilePath());
    }
}
