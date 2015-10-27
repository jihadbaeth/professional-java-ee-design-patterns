package com.devchronicles.interceptor;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import java.util.logging.Logger;

/**
 * @author tanabe
 */
@Secure
@Interceptor
public class SecurityInterceptor {

  @AroundInvoke
  public Object doSecurityCheck(InvocationContext context) throws Exception {
    System.out.println("####: " + getClass().hashCode());
    Logger.getLogger("SecurityLog").info(() ->
      context.getMethod().getName() + " is accessed!");

    String user = (String) context.getContextData().get("user");
    Logger.getLogger("SecurityLog").info("user: " + user);
    if (user == null) {
      user = (String) context.getParameters()[0];
      context.getContextData().put("user", user);
    }
    Logger.getLogger("SecurityLog").info("user: " + user);

    return context.proceed();
  }

  @PostConstruct
  public void onStart() {
    Logger.getLogger("SecurityLog").info(() -> "Activating");
  }

  @PreDestroy
  public void onShutdown() {
    Logger.getLogger("SecurityLog").info(() -> "Deactivating");
  }

}
