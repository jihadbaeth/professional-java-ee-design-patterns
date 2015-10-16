package com.devchronicles.facade;

import javax.ejb.Stateless;

/**
 * @author tanabe
 */
@Stateless
class LoanService {

  public boolean checkCreditRating(long id, double amount) {
    return true;
  }

}
