package page_bo.main_pages;

import org.testng.Assert;

import page.main.SentItemsPage;
import page_bo.main_pages.commonBO.MainMenuBO;

import static config.ConfigManager.conf;

public class SentPageBO extends MainMenuBO {
    SentItemsPage sentItemsPage = new SentItemsPage();

    public void verifySentMail() {
        logger.info("Verify sent mail");
        Assert.assertTrue(sentItemsPage.getSentItemEmail().equals(conf().testemail()));
    }
}
