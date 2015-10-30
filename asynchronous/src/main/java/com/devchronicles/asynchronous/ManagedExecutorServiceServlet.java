package com.devchronicles.asynchronous;

import javax.annotation.Resource;
import javax.enterprise.concurrent.ManagedExecutorService;
import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author Yoshimasa Tanabe
 */
@WebServlet(urlPatterns = "/managed-executor-service", asyncSupported = true)
public class ManagedExecutorServiceServlet extends HttpServlet {

  @Resource(lookup = "java:jboss/ee/concurrency/executor/default")
  private ManagedExecutorService executor;

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    AsyncContext asyncContext = req.startAsync();
    PrintWriter writer = resp.getWriter();

    executor.submit(() -> {
      writer.println("Complete");
      asyncContext.complete();
    });
  }

}
