package com.devchronicles.timer;

import javax.annotation.Resource;
import javax.ejb.ScheduleExpression;
import javax.ejb.Singleton;
import javax.ejb.Timeout;
import javax.ejb.Timer;
import javax.ejb.TimerService;
import javax.ejb.TransactionAttribute;

/**
 * @author tanabe
 */
@Singleton
public class TxProgrammaticTimer {

  @Resource
  private TimerService timerService;

  public void setTimer() {
    ScheduleExpression expression = new ScheduleExpression();
    expression
      .second("*/10")
      .minute("*")
      .hour("*");

    Timer timer = timerService.createCalendarTimer(
      new ScheduleExpression()
        .second("*/10")
        .minute("*")
        .hour("*")
    );
  }

  @Timeout
  @TransactionAttribute
  public void performTask() {
    System.out.println("Tx Simple Task performed");
  }

}
