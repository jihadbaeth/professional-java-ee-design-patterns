package com.devchronicles.decorator.api;

import com.devchronicles.decorator.ProductService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 * @author tanabe
 */
@ApplicationScoped
@Path("/")
public class DecoratorController {

  @Inject
  private ProductService productService;

  @GET
  public String get() {
    return productService.getLabel();
  }

}
