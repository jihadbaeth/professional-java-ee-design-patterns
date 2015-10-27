package com.devchronicles.decorator.api;

import com.devchronicles.decorator.ProductService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 * @author tanabe
 */
@Path("/")
public class DecoratorController {

  @Inject
  private ProductService productService;

  @GET
  public String get() {
    return productService.getLabel();
  }

}
