package com.devchronicles.facade;

import javax.ejb.Stateless;

/**
 * @author tanabe
 */
@Stateless
class AccountService {

  public boolean getLoan(double amount) {
    return true;
  }

  public boolean setCustomerBalance(long id, double amount) {
    return true;
  }

}
