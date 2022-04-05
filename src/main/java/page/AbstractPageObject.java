package page;

import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import driver.DriverManager;

import static org.openqa.selenium.support.PageFactory.initElements;

public abstract class AbstractPageObject {

    protected AbstractPageObject(){
        initElements(new AjaxElementLocatorFactory(DriverManager.getDriver(),3), this);
    }
}
