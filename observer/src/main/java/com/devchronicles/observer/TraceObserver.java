package com.devchronicles.observer;

import com.devchronicles.observer.MessageEvent.Type;

import javax.ejb.Stateless;
import javax.enterprise.event.Observes;
import java.util.logging.Logger;

/**
 * @author Yoshimasa Tanabe
 */
@Stateless
public class TraceObserver {

  private static final Logger LOGGER = Logger.getLogger(TraceObserver.class.getName());

  public void serviceTrace(
    @Observes @MessageEvent(Type.SERVICE) Message message) {

    LOGGER.info(() -> "Service message: " + message);
  }

  public void parameterTrace(
    @Observes @MessageEvent(Type.PARAMETER) Message message) {

    LOGGER.info(() -> "with parametres: " + message);
  }

}
