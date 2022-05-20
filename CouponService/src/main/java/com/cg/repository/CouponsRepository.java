package com.cg.repository;



import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.cg.model.Coupons;



public interface CouponsRepository extends MongoRepository<Coupons, Integer> {
	public Optional<Coupons> findBycname(String couponName);

}
