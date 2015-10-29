package com.devchronicles.asynchronous;

import javax.annotation.PostConstruct;
import javax.ejb.Asynchronous;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

/**
 * @author Yoshimasa Tanabe
 */
@Startup
@Singleton
public class MyLoggingBean {

  private Logger logger;

  @PostConstruct
  public void start() {
    logger = Logger.getLogger("MyGlobalLogger");
    logger.info(() -> "Wel, I started first!!!");
  }

  public void info(String message) {
    logger.info("Entering sync log");

    try {
      TimeUnit.SECONDS.sleep(1);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    logger.info(() -> message);
  }

  @Asynchronous
  public void infoAsync(String message) {
    logger.info("Entering async log");

    try {
      TimeUnit.SECONDS.sleep(10);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    logger.info(() -> message);
  }

}
