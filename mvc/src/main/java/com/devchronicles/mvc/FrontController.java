package com.devchronicles.mvc;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Yoshimasa Tanabe
 */
@WebServlet("/users/*")
public class FrontController extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    try {
      Action action = AbstractActionFactory.getInstance().getAction(request);
      String view = action.execute(request, response);
      getServletContext().getRequestDispatcher(view).forward(request, response);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

}
