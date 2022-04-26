package logging;

import io.qameta.allure.Allure;
import org.apache.log4j.Logger;

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

    public static void log(LogLevels lvl, String message){
        switch (lvl){
            case INFO:
                logger.info(message);
                break;
            case WARN:
                logger.warn(message);
                break;
            case ERROR:
                logger.error(message);
                break;
            case FATAL:
                logger.fatal(message);
                break;
        }

    }
}
