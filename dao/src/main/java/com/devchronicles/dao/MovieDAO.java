package com.devchronicles.dao;

import java.util.List;

/**
 * @author Yoshimasa Tanabe
 */
public interface MovieDAO extends BaseDAO<Movie, Integer> {

  List<Movie> findAllMovies();

}
