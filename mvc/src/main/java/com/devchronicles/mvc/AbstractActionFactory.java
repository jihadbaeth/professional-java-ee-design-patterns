package com.devchronicles.mvc;

/**
 * @author Yoshimasa Tanabe
 */
public class AbstractActionFactory {

  private final static ActionFactory instance = new ActionFactory();

  public static ActionFactory getInstance() {
    return instance;
  }

}
