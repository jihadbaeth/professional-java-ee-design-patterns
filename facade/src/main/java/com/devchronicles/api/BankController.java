package com.devchronicles.api;

import com.devchronicles.facade.BankServiceFacade;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * @author tanabe
 */
@Path("/")
public class BankController {

  @Inject
  private BankServiceFacade bankServiceFacade;

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public String getLoan() {
    boolean result = bankServiceFacade.getLoan(1, 1D);
    return String.format("{\"result\":%s}", result);
  }

}
