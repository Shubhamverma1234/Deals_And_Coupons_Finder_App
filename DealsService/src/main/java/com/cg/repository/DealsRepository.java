package com.cg.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.cg.model.Deals;


public interface DealsRepository extends MongoRepository<Deals, Integer> {
   public Optional<Deals> findBydname(String dealName) ;
	
}
