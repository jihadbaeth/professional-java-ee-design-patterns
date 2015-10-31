package com.devchronicles.observer;

/**
 * @author Yoshimasa Tanabe
 */
public class ChildrenMessage {

  private String value;

  public ChildrenMessage(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }

  @Override
  public String toString() {
    return "ChildrenMessage{" +
      "value='" + value + '\'' +
      '}';
  }

}
