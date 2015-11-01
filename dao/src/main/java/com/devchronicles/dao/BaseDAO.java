package com.devchronicles.dao;

import javax.ejb.Stateless;

/**
 * @author Yoshimasa Tanabe
 */
@Stateless
public interface BaseDAO<E, K> {

  void create(E entity);
  E retrieve(K id);
  void update(E entity);
  void delete(K id);

}
