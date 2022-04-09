package page;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import driver.DriverManager;
import page_bo.main_pages.commonBO.MainMenuBO;

import static org.openqa.selenium.support.PageFactory.initElements;

public abstract class AbstractPageObject {

    protected AbstractPageObject(){
        initElements(new AjaxElementLocatorFactory(DriverManager.getDriver(),3), this);
    }
    protected static final Logger logger1 = Logger.getLogger(MainMenuBO.class);

}
