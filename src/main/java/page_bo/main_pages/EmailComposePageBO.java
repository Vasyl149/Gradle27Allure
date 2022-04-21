package page_bo.main_pages;

import io.qameta.allure.Step;
import org.testng.Assert;
import page.main.EmailComposePage;
import page_bo.main_pages.commonBO.MainMenuBO;

import java.io.FileNotFoundException;

public class EmailComposePageBO extends MainMenuBO {
    EmailComposePage emailComposePage = new EmailComposePage();

    @Step("Create a new mail")
    public EmailComposePageBO createNewMail() {
        openComposePage();
        logger.info("Edit font style");
        emailComposePage.boldButton();
        emailComposePage.italicButton();
        logger.info("Switch to textarea frame");
        emailComposePage.switchToTextArea();
        logger.info("send text to textarea");
        emailComposePage.fillTextField();
        return this;

    }

    @Step("Verify the style of the elements")
    public EmailComposePageBO verifyStyleEditingElements() {
        logger.info("Verify the style of the elements");
        Assert.assertEquals(emailComposePage.fontStyle(), "italic");
        Assert.assertEquals(emailComposePage.fontWeight(), "700");
        return this;
    }

    @Step("Verify fonts in the dropdown")
    public EmailComposePageBO verifyFontsInDropdown() {
        logger.info("Switch to parent frame");
        emailComposePage.switchToParentFrame();
        emailComposePage.fontDropdown();
        logger.info("Verify fonts in the dropdown");
        emailComposePage.getFontList().forEach(font -> Assert.assertTrue(font.isDisplayed()));
        return this;
    }

    public EmailComposePageBO addFile() throws FileNotFoundException {
        logger.info("Add file");
        emailComposePage.fileInput();
        return this;
    }
}
