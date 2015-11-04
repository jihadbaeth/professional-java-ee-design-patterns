package com.devchronicles.mvc;

import javax.enterprise.inject.Model;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Yoshimasa Tanabe
 */
@Model
public class ListUsersController {

  private List<String> users = new ArrayList<>();

  public List<String> getUsers() {
    return users;
  }

  public String execute() {
    users.add("John Lennon");
    users.add("Ringo Starr");
    users.add("Paul McCartney");
    users.add("George Harrison");
    return "/listusers.xhtml";
  }

}
