package com.devchronicles.observer;

import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.sound.midi.Soundbank;
import java.util.logging.Logger;

/**
 * @author Yoshimasa Tanabe
 */
@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class Children {

  @Resource
  private SessionContext sc;

  @Inject
  Event<ChildrenMessage> message;

  int[] children = new int[3];

  public void getThirdChild() {
    int thirdChild = children[2];
    message.fire(new ChildrenMessage("Successful event"));
  }

  public void getSixthChild() {
    try {
      int sixthChild = children[5];
    } catch (Exception e) {
      message.fire(new ChildrenMessage("Rollback event occurred."));
      Logger.getLogger(getClass().getName()).info(() -> "Exception caught: " + e);
      sc.setRollbackOnly();
    }
  }

}
