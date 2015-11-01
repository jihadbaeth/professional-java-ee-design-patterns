package com.devchronicles.dao.api;

import com.devchronicles.dao.Movie;
import com.devchronicles.dao.MovieService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * @author tanabe
 */
@Path("/")
public class MovieController {

  @Inject
  private MovieService movieService;

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public List<Movie> findAllMovies() {
    return movieService.findAllMovies();
  }

}
