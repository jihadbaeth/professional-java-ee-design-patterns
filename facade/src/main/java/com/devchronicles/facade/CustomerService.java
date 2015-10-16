package com.devchronicles.facade;

import javax.ejb.Stateless;

/**
 * @author tanabe
 */
@Stateless
class CustomerService {

  public long getCustomer(int sessionID) {
    return 100005L;
  }

  public boolean checkId(long customer) {
    return true;
  }

}
