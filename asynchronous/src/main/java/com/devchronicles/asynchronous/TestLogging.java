package com.devchronicles.asynchronous;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

/**
 * @author Yoshimasa Tanabe
 */
@Singleton
public class TestLogging {

  @EJB
  private MyLoggingBean loggingBean;

  public void testLoggers() {
    System.out.println("call async");
    loggingBean.infoAsync("Log Async");

    System.out.println("call sync");
    loggingBean.info("Log Sync");

    System.out.println("finished");
  }

}
