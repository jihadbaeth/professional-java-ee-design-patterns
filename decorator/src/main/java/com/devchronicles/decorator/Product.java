package com.devchronicles.decorator;

/**
 * @author tanabe
 */
public interface Product {

  void setLabel(String label);
  void setPrice(double price);
  String getLabel();
  double getPrice();
  String generateLabel();

}
