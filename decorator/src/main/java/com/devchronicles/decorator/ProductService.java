package com.devchronicles.decorator;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;

/**
 * @author tanabe
 */
@Dependent
public class ProductService {

  @Inject
  private Product product;

  public String getLabel() {
    return product.generateLabel();
  }

}
