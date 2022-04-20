package page_bo.main_pages;

import io.qameta.allure.Step;
import logging.Log;
import org.testng.Assert;
import page.main.InboxPage;
import page_bo.GeneralBO;
import page_bo.main_pages.commonBO.MainMenuBO;

public class InboxPageBO extends MainMenuBO {
    InboxPage inboxPage = new InboxPage();
    @Step
    public int getUnreadLettersNumber(){
        GeneralBO.logger.info("Get unread letters number");
        Log.log("Get unread letters number");
        return inboxPage.unreadMailList().size();
    }


    @Step
    public InboxPageBO verifyUnreadLettersPresent() {
        GeneralBO.logger.info("Check if there are new emails in the mailbox");
        Assert.assertTrue(inboxPage.unreadMailList().size() > 0);
        Log.log("Message name","Everything passed ");

        return this;
    }
}

