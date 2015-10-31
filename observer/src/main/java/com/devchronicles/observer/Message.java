package com.devchronicles.observer;

/**
 * @author Yoshimasa Tanabe
 */
public class Message {

  private String value;

  public Message(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }

  @Override
  public String toString() {
    return "Message{" +
      "value='" + value + '\'' +
      '}';
  }

}
