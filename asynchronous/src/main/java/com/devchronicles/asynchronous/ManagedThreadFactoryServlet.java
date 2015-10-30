package com.devchronicles.asynchronous;

import javax.annotation.Resource;
import javax.enterprise.concurrent.ManagedThreadFactory;
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
@WebServlet(urlPatterns = "/managed-thread-factory", asyncSupported = true)
public class ManagedThreadFactoryServlet extends HttpServlet {

  @Resource(lookup = "java:jboss/ee/concurrency/factory/default")
  private ManagedThreadFactory factory;

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    AsyncContext asyncContext = req.startAsync();
    PrintWriter writer = resp.getWriter();

    final Data data = new Data();

    factory.newThread(() -> {
      try {
        TimeUnit.SECONDS.sleep(5);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      System.out.println("Using ManagedThreadFactory");
      data.setValue("ManagedThreadFactory");
      writer.println(data);
      asyncContext.complete();
    }).start();

    System.out.println("Read data...");

    writer.write("Results: ");
  }

}
