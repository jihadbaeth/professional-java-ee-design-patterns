package com.devchronicles.dao;

import javax.ejb.Stateless;
import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import java.util.Arrays;
import java.util.List;

/**
 * @author Yoshimasa Tanabe
 */
public class MovieDAOImpl implements MovieDAO {

  private EntityManager em;

  public MovieDAOImpl(EntityManager em) {
    this.em = em;
  }

  public MovieDAOImpl() {}

  @Override
  public List<Movie> findAllMovies() {
    return em.createQuery("SELECT m FROM Movie m", Movie.class)
      .getResultList();
  }

  @Override
  public void create(Movie movie) {
    em.persist(movie);
  }

  @Override
  public Movie retrieve(Integer id) {
    return findAllMovies().get(id);
  }

  @Override
  public void update(Movie movie) {
    em.merge(movie);
  }

  @Override
  public void delete(Integer id) {
    em.remove(retrieve(id));
  }

}
