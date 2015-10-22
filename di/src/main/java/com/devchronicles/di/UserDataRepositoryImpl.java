package com.devchronicles.di;

import javax.enterprise.context.Dependent;

/**
 * @author tanabe
 */
@Dependent
public class UserDataRepositoryImpl implements UserDataRepository {

  @Override
  public void save(User user) {
    System.out.println(this.getClass().getName() + "#save executed.");
  }

}
