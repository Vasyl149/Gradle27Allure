package driver;

import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class BrowserInstance {
    public WebDriver createInstance(String browser){
        WebDriver webdriver = BrowserFactory.valueOf(browser.toUpperCase()).createDriver();
        webdriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        return webdriver;
    }
}
