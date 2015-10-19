package com.devchronicles.singleton;

import javax.annotation.PostConstruct;
import javax.ejb.AccessTimeout;
import javax.ejb.ConcurrencyManagement;
import javax.ejb.ConcurrencyManagementType;
import javax.ejb.DependsOn;
import javax.ejb.EJB;
import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author tanabe
 */
@Startup
@DependsOn("MyLoggingBean")
@ConcurrencyManagement(ConcurrencyManagementType.CONTAINER) // default
@AccessTimeout(120_000L) // default in millisecounds
@Singleton
public class CacheSingletonBean {

  private Map<Integer, String> myCache;

  @EJB
  private MyLoggingBean loggingBean;

  @PostConstruct
  public void start() {
    loggingBean.info("Started!");
    myCache = new HashMap<>();
  }

  @AccessTimeout(value = 30, unit = TimeUnit.SECONDS)
  @Lock(LockType.WRITE)
  public void addUser(Integer id, String name) {
    myCache.put(id, name);
  }

  @Lock(LockType.READ)
  public String getName(Integer id) {
    return myCache.get(id);
  }

}
