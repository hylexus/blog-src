package cn.hylexus.utils;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author hylexus
 * createdAt 2017/11/14
 */
public class Log4j2Test {

    private Logger logger = LoggerFactory.getLogger(Log4j2Test.class);

    @Test
    public void testLog4j2() {
        logger.debug("debug msg");
        logger.info("info msg");
        logger.error("err msg");
        logger.error("an error occur,", new RuntimeException("Oops !!!"));
    }
}
