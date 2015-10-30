package com.devchronicles.timer;

import javax.annotation.Resource;
import javax.ejb.Singleton;
import javax.ejb.Timeout;
import javax.ejb.TimerService;

/**
 * @author tanabe
 */
@Singleton
public class SimpleProgrammaticTimer {

  @Resource
  private TimerService timerService;

  public void setTimer() {
    timerService.createTimer(30_000, "New Timer");
  }

  @Timeout
  public void performTask() {
    System.out.println("Simple Task performed");
  }

}
