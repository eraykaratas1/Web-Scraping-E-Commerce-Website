package com.meher.yazlab.service;

import com.meher.yazlab.model.Product;
import com.meher.yazlab.repository.ProductRepostitory;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    @Autowired
    private final ProductRepostitory productRepostitory;




    @Override
    public List<Product> getAllProducts() {
        return productRepostitory.findAll();
    }
    @Override
    public List<Product> getinlineAllProducts() {
        List<Product> result = productRepostitory.findAll(Sort.by(Sort.Direction.DESC, "price"));

        return result;

    }
    @Override
    public List<Product> getlineAllProducts() {
        List<Product> result = productRepostitory.findAll(Sort.by(Sort.Direction.ASC, "price"));

        return result;

    }
    @Override
    public List<Product> getinlineSkorAllProducts() {
        List<Product> result = productRepostitory.findAll(Sort.by(Sort.Direction.DESC, "skor"));

        return result;

    }
    @Override
    public List<Product> getlineSkorAllProducts() {
        List<Product> result = productRepostitory.findAll(Sort.by(Sort.Direction.ASC, "skor"));

        return result;

    }

    @Override
    public Product saveProduct(Product product) {
        return productRepostitory.save(product);
    }

    @Override
    public Product getProductById(int id) {
        return productRepostitory.findById(id).get();
    }



    @Override
    public Product updateProduct(Product product) {
        return productRepostitory.save(product);
    }

    @Override
    public void deleteProductById(int id) {
        productRepostitory.deleteById(id);
    }



}
