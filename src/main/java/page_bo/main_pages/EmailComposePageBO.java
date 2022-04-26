package page_bo.main_pages;

import io.qameta.allure.Step;
import logging.LogLevels;
import logging.Log;
import org.testng.Assert;
import page.main.EmailComposePage;
import page_bo.main_pages.commonBO.MainMenuBO;

import java.io.FileNotFoundException;

public class EmailComposePageBO extends MainMenuBO {
    EmailComposePage emailComposePage = new EmailComposePage();

    @Step("Create a new mail")
    public EmailComposePageBO createNewMail() {
        openComposePage();
        logger.log(LogLevels.INFO,"Edit font style");
        emailComposePage.boldButton();
        emailComposePage.italicButton();
        logger.log(LogLevels.INFO,"Switch to textarea frame");
        emailComposePage.switchToTextArea();
        logger.log(LogLevels.INFO,"send text to textarea");
        emailComposePage.fillTextField();
        return this;

    }

    @Step("Verify the style of the elements")
    public EmailComposePageBO verifyStyleEditingElements() {
        logger.log(LogLevels.INFO,"Verify the style of the elements");
        Assert.assertEquals(emailComposePage.fontStyle(), "italic");
        Assert.assertEquals(emailComposePage.fontWeight(), "700");
        logger.log("Everything passed");
        return this;
    }

    @Step("Verify fonts in the dropdown")
    public EmailComposePageBO verifyFontsInDropdown() {
        logger.log(LogLevels.INFO,"Switch to parent frame");
        emailComposePage.switchToParentFrame();
        emailComposePage.fontDropdown();
        logger.log(LogLevels.INFO,"Verify fonts in the dropdown");
        emailComposePage.getFontList().forEach(font -> Assert.assertTrue(font.isDisplayed()));
        logger.log("Everything passed");
        return this;
    }

    public EmailComposePageBO addFile() throws FileNotFoundException {
        logger.log(LogLevels.INFO,"Add file");
        emailComposePage.fileInput();
        return this;
    }
}
