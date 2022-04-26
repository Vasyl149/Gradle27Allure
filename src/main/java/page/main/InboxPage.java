package page.main;

import io.qameta.allure.Step;
import logging.LogLevels;
import logging.Log;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import page.AbstractPageObject;

import java.util.List;

public class InboxPage extends AbstractPageObject {

    @FindBy(css = "tr.unread")
    private List<WebElement> unreadMails;


    @Step("Get unread letters number")
    public List<WebElement> unreadMailList(){
        //AbstractPageObject.logger1.info("Get unread letters number");
        logger.log(LogLevels.INFO,"Get unread letters number");
        //Allure.addAttachment("Message name","text/html","result432543");
        return unreadMails;
    }

}
