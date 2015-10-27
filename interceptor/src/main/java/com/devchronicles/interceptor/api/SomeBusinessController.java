package com.devchronicles.interceptor.api;

import com.devchronicles.interceptor.SomeBusinessService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 * @author tanabe
 */
@Path("/")
public class SomeBusinessController {

  @Inject
  private SomeBusinessService someBusinessService;

  @GET
  @Path("/start-service")
  public void startService() {
    someBusinessService.startService("user1");
  }

  @GET
  @Path("/start-another-service")
  public void startAnotherService() {
    someBusinessService.startAnotherService("user2");
  }

}
