package com.devchronicles.rest.api;

import com.devchronicles.rest.User;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

/**
 * @author tanabe
 */
@ApplicationPath("/")
@Path("/")
public class UserController extends Application {

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public Response getUsers() {
    List<User> allUsers = findAllUsers();
    JsonArrayBuilder jsonArrayBuilder = Json.createArrayBuilder();

    allUsers.forEach(user -> {
      jsonArrayBuilder.add(Json.createObjectBuilder()
        .add("id", user.getId())
        .add("first-name", user.getFirstName())
        .add("last-name", user.getLastName())
      );
    });

    JsonArray json = jsonArrayBuilder.build();
    return Response.ok(json.toString()).build();
  }

  private List<User> findAllUsers() {
    List<User> allUsers = new ArrayList<>();
    allUsers.add(new User(123456, "Alex", "Theedom"));
    allUsers.add(new User(456789, "Murat", "Yener"));
    return allUsers;
  }

}
