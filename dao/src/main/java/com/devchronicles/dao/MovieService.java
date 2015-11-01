package com.devchronicles.dao;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

/**
 * @author Yoshimasa Tanabe
 */
@Stateless
public class MovieService {

  @Inject
  MovieDAO movieDAO;

  public List<Movie> findAllMovies() {
    return movieDAO.findAllMovies();
  }

  public void create(Movie movie) {
    movieDAO.create(movie);
  }

  public Movie retrieve(Integer id) {
    return movieDAO.retrieve(id);
  }

  public void update(Movie movie) {
    movieDAO.update(movie);
  }

  public void delete(Integer id) {
    movieDAO.delete(id);
  }

}
