package com.devchronicles.interceptor;

import javax.enterprise.context.Dependent;
import java.util.logging.Logger;

/**
 * @author tanabe
 */
@Secure
@Dependent
public class SomeBusinessService {

  public void startService(String user) {
    Logger.getLogger("AppLog").info("done...");
  }

  public void startAnotherService(String user) {
    Logger.getLogger("AppLog").info("done again...");
  }

}
