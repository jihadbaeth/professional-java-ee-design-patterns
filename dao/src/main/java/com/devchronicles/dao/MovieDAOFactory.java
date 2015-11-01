package com.devchronicles.dao;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author Yoshimasa Tanabe
 */
@ApplicationScoped
public class MovieDAOFactory {

  @PersistenceContext
  private EntityManager em;

  @Produces
  public MovieDAO createMovieDAO() {
    return new MovieDAOImpl(em);
  }

}
