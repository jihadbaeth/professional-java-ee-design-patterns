package com.devchronicles.decorator;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.enterprise.inject.Any;
import javax.inject.Inject;

/**
 * @author tanabe
 */
@Decorator
public class BlackFridayDiscountDecorator implements Product {

  @Any
  @Inject
  @Delegate
  private Product product;

  @Override
  public String generateLabel() {
    System.out.println("################### START: " + this.getClass().getName());
    System.out.println("product HashCode: " + product.hashCode());
    System.out.println("product Before: " + product);
    product.setPrice(product.getPrice() * 0.25);
    product.setLabel(product.getLabel());
    System.out.println("product After: " + product);
    System.out.println("################### END: " + this.getClass().getName());
    return product.generateLabel();
  }

  @Override
  public void setLabel(String label) {}

  @Override
  public void setPrice(double price) {}

  @Override
  public String getLabel() { return null; }

  @Override
  public double getPrice() { return 0; }

}
