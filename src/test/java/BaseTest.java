import driver.BrowserInstance;
import driver.DriverManager;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import page_bo.main_pages.loginPageBO.LoginPageBO;

import static config.ConfigManager.conf;

public abstract class BaseTest {
    //protected static final Logger logger = Logger.getLogger(MainMenuBO.class);
    //private final String browser = "Chrome";
    //WebDriver driver;
    //Uncomment for jenkins ↓
    private final String browser = System.getProperty("environment");

    @BeforeClass
    //@Parameters("browser")
    @Step("Login to the application")
    public void preCondition() {
        WebDriver driver = new BrowserInstance().createInstance(browser);
        System.out.println(System.getProperty("environment"));
        DriverManager.setDriver(driver);
        DriverManager.getDriver().get(conf().url());

//        driver = new ChromeDriver();
//
//        driver.get("https://accounts.ukr.net/login");

        new LoginPageBO().logIn();
    }

    @Step("Driver quit")
    @AfterClass
    public void postCondition() {
        DriverManager.quit();
    }


}
