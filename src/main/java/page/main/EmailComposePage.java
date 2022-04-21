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

    @Step("Click on \"Bold\" button")
    public void boldButton() {
        boldButton.click();
    }
    @Step("Click on \"Italic\" button")
    public void italicButton() {
        italicButton.click();
    }

    @Step("Switch to the text area")
    public void switchToTextArea(){
        DriverManager.getDriver().switchTo().frame(textArea);
    }

    @Step("Switch to parent frame")
    public void switchToParentFrame(){
        DriverManager.getDriver().switchTo().parentFrame();
    }

    @Step("Fill in the text field")
    public void fillTextField(){
        textField.sendKeys(conf().message());
    }

    @Step("Get font style")
    public String fontStyle(){
        return message.getCssValue("font-style");
    }

    @Step("Get font weight")
    public String fontWeight(){
        return message.getCssValue("font-weight");
    }

    @Step("Open drop-down with fonts")
    public void fontDropdown(){
        fontDropdown.click();
    }

    @Step("Get a list of fonts")
    public List<WebElement> getFontList(){
        return fontList;
    }

    public void fileInput() throws FileNotFoundException {
       fileInput.sendKeys(conf().testFilePath());
    }
}
