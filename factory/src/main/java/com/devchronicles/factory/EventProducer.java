package com.devchronicles.factory;

import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Produces;

/**
 * @author tanabe
 */
@Dependent
public class EventProducer {

  @Produces @ShortMessage
  public MessageA messageAFactory() {
    return new MessageA();
  }

  @Produces @LongMessage
  public MessageB messageBFactory() {
    return new MessageB();
  }

}
