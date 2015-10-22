package com.devchronicles.di.api;

import com.devchronicles.di.User;
import com.devchronicles.di.UserService;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

/**
 * @author tanabe
 */
@Path("/")
public class UserController {

  @Inject
  private UserService userService;

  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  public Response register(@Context UriInfo uriInfo, User user) {
    userService.persistUser(user);
    return Response
      .created(uriInfo.getAbsolutePathBuilder()
        .path(user.getFullName())
        .build())
      .build();
  }

}
