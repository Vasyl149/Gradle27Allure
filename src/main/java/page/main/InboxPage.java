package page.main;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import page.AbstractPageObject;

import java.util.List;

public class InboxPage extends AbstractPageObject {

    @FindBy(css = "tr.unread")
    private List<WebElement> unreadMails;


    @Step
    public List<WebElement> unreadMailList(){
        return unreadMails;
    }

}
