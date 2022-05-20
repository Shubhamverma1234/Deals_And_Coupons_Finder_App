package com.cg.controller;



import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.exception.CouponAlreadyExistsException;
import com.cg.exception.CouponIdNotFound;
import com.cg.exception.NameNotFoundException;
import com.cg.model.Coupons;

import com.cg.service.CouponsService;

@RestController
@RequestMapping("/api/c2")
public class CouponsServiceController {
	@Autowired
	private CouponsService couponServ;
	
//Get all coupons by user
	@GetMapping("/coupons")
	public ResponseEntity<List<Coupons>> getAllCoupons(){
        return new ResponseEntity<List<Coupons>>((List<Coupons>)couponServ.getAllCoupons(),HttpStatus.OK);
    }
//Get all coupons by user using  coupon's name 
	 @GetMapping("/getcoupons/{cname}")
	    public ResponseEntity < Coupons > getCouponsDataByname(@PathVariable String cname) throws NameNotFoundException {
	        return ResponseEntity.ok().body(couponServ.getCouponsDataByname(cname));
	    }
//Get all Coupons by user using coupon's id	 
	 @GetMapping("/getcouponid/{id}")
	    public ResponseEntity < Coupons > getCouponDataById(@PathVariable int id) throws CouponIdNotFound {
	        return ResponseEntity.ok().body(couponServ.getCouponDataById(id));
	 }


	
}
