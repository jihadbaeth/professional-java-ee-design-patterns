package com.devchronicles.timer;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ejb.Timer;
import javax.ejb.TimerService;
import java.util.Collection;

/**
 * @author tanabe
 */
@Singleton
@Startup
public class AllTimers {

  @Resource
  private TimerService timerService;

  @PostConstruct
  public void manageTimer() {
    System.out.println("### AllTimers#manageTimer START");
    Collection<Timer> timers = timerService.getAllTimers();
    timers.forEach(timer -> {
      System.out.println("Timer Info: " + timer.getInfo());
      System.out.println("Time Remaining: " + timer.getTimeRemaining());
      timer.cancel();
    });
    System.out.println("### AllTimers#manageTimer END");
  }

}
