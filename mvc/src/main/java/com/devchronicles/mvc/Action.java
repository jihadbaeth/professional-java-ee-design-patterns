package com.devchronicles.mvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Yoshimasa Tanabe
 */
public interface Action {

  String execute(HttpServletRequest request, HttpServletResponse response) throws Exception;

}
