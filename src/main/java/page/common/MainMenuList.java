package page.common;

import io.qameta.allure.Step;
import logging.Log;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import page.AbstractPageObject;

import java.util.List;

public class MainMenuList extends AbstractPageObject {

    @FindBy(css = "button[class*='button primary compose']")
    private WebElement composeButton;

    @FindBy(className = "sidebar__list-link-name")
    private List<WebElement> menuList;

    @FindBy(xpath = "//div[@class='sidebar__list-item']/a[@id='0'  and @class[contains(.,'current')]]")
    private WebElement inboxButton;

    @FindBy(css = "a[id='0']>span.sidebar__list-link-count")
    private WebElement counter;

    @FindBy(css = "a[id='10002']")
    private WebElement draftsButton;

    @FindBy(css = "a[data-folder='10001']")
    private WebElement sentItemsButton;

    @FindBy(css = "a[data-folder='unread']")
    private WebElement unreadButton;

    @FindBy(css = "span.sidebar__list-link-icon")
    private List<WebElement> icons;

    @FindBy(css = "a[id='10002']>span.sidebar__list-link-count")
    private WebElement countOfDrafts;

    @Step
    public void composeButton() {
        composeButton.click();
    }

    @Step
    public WebElement getComposeButton() {
        return composeButton;
    }

    @Step("Get menu list")
    public List<WebElement> menuList() {
        return menuList;
    }

    @Step
    public void inboxButton() {
        inboxButton.click();
    }

    @Step("Get inbox tab")
    public WebElement inboxTab() {
        return inboxButton;
    }

    @Step("Get count of unread mails")
    public String getCounter() {
        return counter.getText();
    }

    @Step
    public void draftsButton() {
        draftsButton.click();
    }

    @Step
    public void sentItemsButton() {
        sentItemsButton.click();
    }

    @Step
    public void unreadButton() {
        unreadButton.click();
    }


    @Step("Get icon list")
    public List<WebElement> iconList() {
        return icons;
    }

    @Step
    public int getCountOfDrafts() {
        return Integer.parseInt(countOfDrafts.getText());

    }


}
