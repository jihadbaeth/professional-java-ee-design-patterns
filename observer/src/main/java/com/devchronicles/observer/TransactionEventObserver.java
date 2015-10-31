package com.devchronicles.observer;

import javax.ejb.Stateless;
import javax.enterprise.event.Observes;
import javax.enterprise.event.TransactionPhase;
import javax.sound.midi.Soundbank;
import java.util.logging.Logger;

/**
 * @author Yoshimasa Tanabe
 */
@Stateless
public class TransactionEventObserver {

  private static final Logger LOGGER = Logger.getLogger(TransactionEventObserver.class.getName());
  
  public void onInProgress(@Observes ChildrenMessage message) {
    LOGGER.info("In progress message: " + message);
  }

  public void onSuccess(@Observes(during = TransactionPhase.AFTER_SUCCESS) ChildrenMessage message) {
    LOGGER.info("After success message: " + message);
  }

  public void onFailure(@Observes(during = TransactionPhase.AFTER_FAILURE) ChildrenMessage message) {
    LOGGER.info("After failure message: " + message);
  }

  public void onCompletion(@Observes(during = TransactionPhase.AFTER_COMPLETION) ChildrenMessage message) {
    LOGGER.info("After completion message: " + message);
  }

}
