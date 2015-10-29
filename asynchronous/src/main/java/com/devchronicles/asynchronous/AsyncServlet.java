package com.devchronicles.asynchronous;

import javax.servlet.AsyncContext;
import javax.servlet.AsyncEvent;
import javax.servlet.AsyncListener;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * @author Yoshimasa Tanabe
 */
@WebServlet(urlPatterns = "/async", asyncSupported = true)
public class AsyncServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    AsyncContext asyncContext = req.startAsync();

    final Data data = new Data();

    asyncContext.addListener(new AsyncListener() {
      @Override
      public void onComplete(AsyncEvent event) throws IOException {
        AsyncContext asyncContext = event.getAsyncContext();
        asyncContext.getResponse().getWriter().println(data);
      }

      @Override
      public void onTimeout(AsyncEvent event) throws IOException {}

      @Override
      public void onError(AsyncEvent event) throws IOException {}

      @Override
      public void onStartAsync(AsyncEvent event) throws IOException {}
    });

    new Thread(() -> {
      try {
        TimeUnit.SECONDS.sleep(5);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      data.setValue("Foo");
      asyncContext.complete();
    }).start();

    System.out.println("Read data...");

    resp.getWriter().write("Results: ");
  }

}
