package logging;

import org.apache.log4j.Logger;
/**
 * Created by LanAnh on 25/12/2016.
 */
public class LoggingDemo {
    public static void main(String[] args) {
        final Logger logger = Logger.getLogger(LoggingDemo.class);
        logger.debug("debug statement");
        logger.info("info statement");
        logger.error("error statement");
    }
}
