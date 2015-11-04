package com.devchronicles.mvc;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Yoshimasa Tanabe
 */
public class ActionFactory {

  private Map<String, Action> actions = new HashMap<>();
  private Action action;

  public ActionFactory() {
    actions.put("GET/users", new HomeAction());
    actions.put("GET/users/listusers", new ListUsersAction());
  }

  public synchronized Action getAction(HttpServletRequest request) {
    String path = request.getServletPath() + request.getPathInfo();
    String actionKey = request.getMethod() + path;
    System.out.println(actionKey);
    action = actions.get(actionKey);

    if (action == null) {
      action = actions.get("GET/users");
    }

    return action;
  }
}
