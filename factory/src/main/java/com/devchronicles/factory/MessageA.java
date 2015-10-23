package com.devchronicles.factory;

import javax.enterprise.inject.Alternative;

/**
 * @author tanabe
 */
@Alternative
public class MessageA {

  private String message;

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

}
