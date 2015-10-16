package com.devchronicles.facade;

import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * @author tanabe
 */
@Stateless
public class BankServiceFacade {

  @Inject
  private CustomerService customerService;

  @Inject
  private LoanService loanService;

  @Inject
  private AccountService accountService;

  public boolean getLoan(int sessionId, double amount) {
    boolean result = false;
    long id = customerService.getCustomer(sessionId);

    if (customerService.checkId(id)) {
      if (loanService.checkCreditRating(id, amount)) {
        if (accountService.getLoan(amount)) {
          result = accountService.setCustomerBalance(id, amount);
        }
      }
    }

    return result;
  }

}
