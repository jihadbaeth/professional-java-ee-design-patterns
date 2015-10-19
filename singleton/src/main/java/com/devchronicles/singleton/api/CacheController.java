package com.devchronicles.singleton.api;

import com.devchronicles.singleton.CacheSingletonBean;
import com.devchronicles.singleton.User;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

/**
 * @author tanabe
 */
@Path("/")
public class CacheController {

  @Inject
  private CacheSingletonBean cacheSingletonBean;

  @GET
  @Path("{id}")
  @Produces(MediaType.APPLICATION_JSON)
  public Response get(@PathParam("id") int id) {
    String name = cacheSingletonBean.getName(id);

    if (name == null) {
      return Response.status(Response.Status.NOT_FOUND).build();
    }

    return Response.ok(name).build();
  }

  @PUT
  @Consumes(MediaType.APPLICATION_JSON)
  public Response put(@Context UriInfo uriInfo, User user) {
    cacheSingletonBean.addUser(user.getId(), user.getName());
    return Response
      .created(uriInfo.getAbsolutePathBuilder()
        .path(String.valueOf(user.getId()))
        .build())
      .build();
  }

}
