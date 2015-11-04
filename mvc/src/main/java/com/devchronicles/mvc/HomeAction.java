package com.devchronicles.mvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Yoshimasa Tanabe
 */
public class HomeAction implements Action {

  @Override
  public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
    return "/WEB-INF/pages/home.jsp";
  }

}
