package com.devchronicles.factory.api;

import com.devchronicles.factory.EventService;

import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

/**
 * @author tanabe
 */
@Path("/")
public class EventController {

  @Inject
  private EventService eventService;

  @POST
  public void startService() {
    eventService.startService();
  }

}
