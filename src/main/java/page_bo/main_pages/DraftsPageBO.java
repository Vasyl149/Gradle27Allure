package page_bo.main_pages;

import io.qameta.allure.Step;
import org.testng.Assert;
import page.main.DraftsPage;
import page_bo.main_pages.commonBO.MainMenuBO;

public class DraftsPageBO extends MainMenuBO {
    DraftsPage draftsPage = new DraftsPage();

    @Step("Verify is user can send draft")
    public DraftsPageBO verifySendDraft() throws InterruptedException {
        logger.info("Select first draft");
        draftsPage.firstDraft();
        logger.info("click send button");
        draftsPage.sendButton();
        logger.info("close alert");
        draftsPage.closeAlert();
        logger.info("fill in email field");
        draftsPage.fillEmailField();
        Thread.sleep(1000);
        logger.info("click send button");
        draftsPage.sendButton();
        Thread.sleep(4000);
        //Assert.assertTrue(draftsPage.confirmMessage().isDisplayed());
        Assert.assertTrue(false);
        return this;
    }
}
