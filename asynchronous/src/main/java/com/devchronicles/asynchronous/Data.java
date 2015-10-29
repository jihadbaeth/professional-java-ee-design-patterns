package com.devchronicles.asynchronous;

/**
 * @author Yoshimasa Tanabe
 */
public class Data {

  private String value;

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  @Override
  public String toString() {
    return "Data{" +
      "value='" + value + '\'' +
      '}';
  }

}
