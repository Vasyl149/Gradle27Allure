package page_bo.main_pages.commonBO;

import io.qameta.allure.Step;
import logging.Log;
import logging.LogLevels;
import org.testng.Assert;
import page.common.MainMenuList;
import page_bo.GeneralBO;
import page_bo.main_pages.DraftsPageBO;
import page_bo.main_pages.EmailComposePageBO;
import page_bo.main_pages.SentPageBO;
import page_bo.main_pages.UnreadPageBO;

import java.io.UnsupportedEncodingException;


public class MainMenuBO extends GeneralBO {

    MainMenuList mainMenuList = new MainMenuList();

    public EmailComposePageBO openComposePage() {
       // logger.info("open Compose page");
        logger.log(LogLevels.ERROR,"f");
        mainMenuList.composeButton();
        return new EmailComposePageBO();
    }

    public DraftsPageBO draftButton() {
        mainMenuList.draftsButton();
        return new DraftsPageBO();
    }

    public SentPageBO sentButton() {
        mainMenuList.sentItemsButton();
        return new SentPageBO();
    }

    public UnreadPageBO clickUnreadButton() throws InterruptedException {
        Thread.sleep(3000);
        mainMenuList.unreadButton();
        return new UnreadPageBO();
    }

    @Step
    public void verifyComposeButton() {
        Assert.assertTrue(mainMenuList.getComposeButton().isDisplayed());
    }

    @Step("Check if 'Inbox' tab is selected")
    public MainMenuBO verifyInboxIsSelected() {
        //logger.info("Check if 'Inbox' tab is selected");
        //Log_1.log("Logs","Check if 'Inbox' tab is selected");
        logger.log(LogLevels.INFO,"Check if 'Inbox' tab is selected");
        Assert.assertTrue(mainMenuList.inboxTab().getAttribute("Class").contains("current"));
        logger.log("Everything passed");

        return this;
    }

    @Step("Check if menu list contains 8 items")
    public MainMenuBO verifyNavigationMenu() throws InterruptedException, UnsupportedEncodingException {
       // logger.info("Check if menu list contains 8 items");
        logger.log(LogLevels.INFO,"Check if menu list contains 8 items" +
                        "\nCheck if menu consist of  'Inbox', 'Drafts', 'Sent', 'Spam' etc.");

        Assert.assertEquals(mainMenuList.menuList().size(), 8);
        logger.log("Everything passed");
//        logger.info("Check if menu consist of  'Inbox', 'Drafts', 'Sent', 'Spam' etc.");
//        List<String> menuListNames = new ArrayList<>();
//
//        mainMenuList.menuList().forEach(el -> menuListNames.add(el.getText()));

        Thread.sleep(5000);
        //logger.info(MenuListEnum.getNamesOfItems());
        // logger.info(menuListNames);
        //Assert.assertTrue(MenuListEnum.getNamesOfItems().equals(menuListNames));

//        logger.info("Check if icons are displayed on left menu");
//        mainMenuList.iconList().forEach(ic -> Assert.assertTrue(ic.isDisplayed()));
//        Log.log("Message name","Everything passed ");
        return this;
    }

    @Step("Check if icons are displayed on left menu")
    public MainMenuBO verifyMenuIcons(){
        logger.log(LogLevels.INFO,"Check if icons are displayed on left menu");
        mainMenuList.iconList().forEach(ic -> Assert.assertTrue(ic.isDisplayed()));
        logger.log("Everything passed");
        return this;
    }

    @Step("Check if message counter is equal to the number of messages")
    public MainMenuBO verifyUnreadLettersNumber(int expectedNumber) {
        logger.log(LogLevels.INFO,"Check if message counter is equal to the number of messages");
        Assert.assertTrue(mainMenuList.getCounter().equals(String.valueOf(expectedNumber)));
        logger.log("Everything passed");
        return this;
    }

    @Step("Get count of drafts")
    public int getDraftsNumber() {
       // logger.info("Get drafts number");
        return mainMenuList.getCountOfDrafts();
    }

    @Step ("Verify If drafts number was increased")
    public UnreadPageBO verifyDraftsNumber(int newValue, int oldValue) {
       // logger.info("Verify Drafts number");
        Assert.assertTrue(newValue == (oldValue + 1));
        logger.log("Everything passed");
        return new UnreadPageBO();
    }


}
