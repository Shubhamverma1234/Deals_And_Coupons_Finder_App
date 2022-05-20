package com.cg.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;


import com.cg.model.Product;


public interface ProductRepository extends MongoRepository<Product, Integer> {
	public Optional<Product> findBypname(String productName);

}
