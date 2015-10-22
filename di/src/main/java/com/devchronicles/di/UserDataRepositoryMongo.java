package com.devchronicles.di;

import javax.enterprise.context.Dependent;
import javax.inject.Named;

/**
 * @author tanabe
 */
@Dependent
@Named
public class UserDataRepositoryMongo implements UserDataRepository {

  @Override
  public void save(User user) {
    System.out.println(this.getClass().getName() + "#save executed.");
  }

}
