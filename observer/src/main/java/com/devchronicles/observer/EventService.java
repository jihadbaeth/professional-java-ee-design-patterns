package com.devchronicles.observer;

import com.devchronicles.observer.MessageEvent.Type;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.enterprise.event.Event;
import javax.inject.Inject;

/**
 * @author Yoshimasa Tanabe
 */
@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class EventService {

//  @Inject
  private Message message = new Message("produced message");

  @Inject
  @MessageEvent(Type.SERVICE)
  Event<Message> serviceEvent;

  @Inject
  @MessageEvent(Type.PARAMETER)
  Event<Message> parameterEvent;

  public void startService() {
    serviceEvent.fire(new Message("Starting service " + message.getValue()));
    parameterEvent.fire(new Message("-d -p"));
  }

}
