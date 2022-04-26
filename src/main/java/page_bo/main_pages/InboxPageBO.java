package page_bo.main_pages;

import io.qameta.allure.Step;
import logging.Log;
import logging.LogLevels;
import org.testng.Assert;
import page.main.InboxPage;
import page_bo.main_pages.commonBO.MainMenuBO;

public class InboxPageBO extends MainMenuBO {
    InboxPage inboxPage = new InboxPage();
    @Step("Get unread letters number")
    public int getUnreadLettersNumber(){
        //GeneralBO.logger.info("Get unread letters number");
        //Log_1.log("Get unread letters number");
        logger.log(LogLevels.INFO,"Get unread letters number");
        return inboxPage.unreadMailList().size();
    }


    @Step("Check if there are new emails in the mailbox")
    public InboxPageBO verifyUnreadLettersPresent() {
        //GeneralBO.logger.info("Check if there are new emails in the mailbox");
        logger.log(LogLevels.INFO,"Check if there are new emails in the mailbox");
        Assert.assertTrue(inboxPage.unreadMailList().size() > 0);
        logger.log("Everything passed");

        return this;
    }
}

