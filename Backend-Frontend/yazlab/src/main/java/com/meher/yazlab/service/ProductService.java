package com.meher.yazlab.service;

import com.meher.yazlab.model.Product;

import java.util.List;


public interface ProductService{

    List<Product> getAllProducts();

    Product saveProduct(Product product);

    Product getProductById(int id);



    Product updateProduct(Product product);

    void deleteProductById(int id);

    List<Product> getinlineAllProducts();
    List<Product> getlineAllProducts();

    List<Product> getinlineSkorAllProducts();

    List<Product> getlineSkorAllProducts();





}
