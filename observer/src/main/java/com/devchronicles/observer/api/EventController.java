package com.devchronicles.observer.api;

import com.devchronicles.observer.Children;
import com.devchronicles.observer.EventService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 * @author tanabe
 */
@Path("/")
public class EventController {

  @Inject
  private EventService eventService;

  @Inject
  private Children children;

  @GET
  public void get() {
    eventService.startService();
  }

  @GET
  @Path("third-child")
  public void getThirdChild() {
    children.getThirdChild();
  }

  @GET
  @Path("sixth-child")
  public void getSixthChild() {
    children.getSixthChild();
  }

}
