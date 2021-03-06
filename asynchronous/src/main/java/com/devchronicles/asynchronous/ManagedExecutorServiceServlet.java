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
import java.util.concurrent.TimeUnit;

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

    final Data data = new Data();

    executor.submit(() -> {
      try {
        TimeUnit.SECONDS.sleep(5);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      System.out.println("Using ManagedExecutorService");
      data.setValue("ManagedExecutorService");
      writer.println(data);
      asyncContext.complete();
    });

    System.out.println("Read data...");

    writer.write("Results: ");
  }

}
