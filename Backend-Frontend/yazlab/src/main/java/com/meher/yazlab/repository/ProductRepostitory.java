package com.meher.yazlab.repository;

import com.meher.yazlab.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductRepostitory extends MongoRepository<Product, Integer> {




}
