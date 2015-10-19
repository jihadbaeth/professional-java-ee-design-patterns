package com.devchronicles.singleton;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import java.util.logging.Logger;

/**
 * @author tanabe
 */
@Startup
@Singleton
public class MyLoggingBean {

  private Logger logger;

  @PostConstruct
  public void start() {
    logger = Logger.getLogger("MyGlobalLogger");
    logger.info("Well, I started first!!!");
  }

  public void info(String message) {
    logger.info(message);
  }

}
