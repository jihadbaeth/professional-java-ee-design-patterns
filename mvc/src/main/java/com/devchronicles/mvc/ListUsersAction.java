package com.devchronicles.mvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Yoshimasa Tanabe
 */
public class ListUsersAction implements Action {

  @Override
  public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
    List<String> users = new ArrayList<>();
    users.add("John Lennon");
    users.add("Ringo Starr");
    users.add("Paul McCartney");
    users.add("George Harrison");
    request.setAttribute("listusers", users);
    return "/WEB-INF/pages/listusers.jsp";
  }

}
