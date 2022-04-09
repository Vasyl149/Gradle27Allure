package page.main;

import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import page.AbstractPageObject;
import page_bo.GeneralBO;

import java.util.List;

public class InboxPage extends AbstractPageObject {

    @FindBy(css = "tr.unread")
    private List<WebElement> unreadMails;


    @Step
    public List<WebElement> unreadMailList(){
        AbstractPageObject.logger1.info("Get unread letters number");
        Allure.addAttachment("hello4543","text/html","result432543");
        return unreadMails;
    }

}
