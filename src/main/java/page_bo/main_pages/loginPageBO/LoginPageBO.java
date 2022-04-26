package page_bo.main_pages.loginPageBO;

import logging.Log;
import logging.LogLevels;
import page.login.LoginPage;
import page_bo.GeneralBO;

public class LoginPageBO extends GeneralBO {
    LoginPage loginPage = new LoginPage();

    public void logIn(){
        loginPage.setCredentials();
        logger.log(LogLevels.INFO,"Fill login and password");
        loginPage.clickContinue();
        logger.log(LogLevels.INFO,"Click 'Continue' button");
    }
}
