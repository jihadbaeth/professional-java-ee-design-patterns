package com.devchronicles.di;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * @author tanabe
 */
@Dependent
public class UserService {

  @Inject
  @Named
  private UserDataRepository userDataRepositoryMongo;

  public void persistUser(User user) {
    userDataRepositoryMongo.save(user);
  }

}
