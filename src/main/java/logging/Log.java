package logging;

import io.qameta.allure.Allure;
import org.apache.log4j.Logger;
import page_bo.main_pages.commonBO.MainMenuBO;

public class Log {
    public static final Logger logger = Logger.getLogger(Log.class);

    public static void log(String messageName,String message){
        logger.info(message);
        Allure.addAttachment(messageName,"text/html",message);
    }

    public static void log(String message){
        logger.info(message);
        Allure.addAttachment("Test result","text/html",message);
    }
}
