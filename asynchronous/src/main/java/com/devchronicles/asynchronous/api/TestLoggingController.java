package com.devchronicles.asynchronous.api;

import com.devchronicles.asynchronous.TestLogging;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 * @author Yoshimasa Tanabe
 */
@Path("/test-logging")
public class TestLoggingController {

  @Inject
  private TestLogging testLogging;

  @GET
  public void testLogging() {
    testLogging.testLoggers();
  }

}
