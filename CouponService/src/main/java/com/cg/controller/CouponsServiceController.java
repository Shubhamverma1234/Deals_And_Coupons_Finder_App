package com.cg.controller;



import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.exception.CouponAlreadyExistsException;
import com.cg.exception.CouponIdNotFound;

import com.cg.exception.NameNotFoundException;
import com.cg.model.Coupons;

import com.cg.service.CouponsService;

@RestController
@RequestMapping("/api/c1")
public class CouponsServiceController {
	@Autowired
	private CouponsService couponServ;

   //Create Coupons by admin
	
	@PostMapping("/coupon")
	 public ResponseEntity<Coupons> addAgency(@RequestBody Coupons coupon )throws CouponAlreadyExistsException{
       Coupons saveddeal = couponServ.addCoupon(coupon);
      return new ResponseEntity<>(saveddeal, HttpStatus.CREATED);
  }
	//Get All Coupons by admin
	
	@GetMapping("/coupons")
	public ResponseEntity<List<Coupons>> getAllCoupons(){
        return new ResponseEntity<List<Coupons>>((List<Coupons>)couponServ.getAllCoupons(),HttpStatus.OK);
    }
	
	//Get coupons by Coupon Name by admin
	
	@GetMapping("/getcoupons/{cname}")
	    public ResponseEntity < Coupons > getCouponsDataByname(@PathVariable String cname) throws NameNotFoundException {
	        return ResponseEntity.ok().body(couponServ.getCouponsDataByname(cname));
	    }
	 
	 //Get Coupon By Coupon Id by admin
	
	 @GetMapping("/getcouponid/{id}")
	    public ResponseEntity < Coupons > getCouponDataById(@PathVariable int id) throws CouponIdNotFound {
	        return ResponseEntity.ok().body(couponServ.getCouponDataById(id));
	 }
	 
	// to delete Record by admin
	
	 @DeleteMapping("/coupondele/{couponno}") 
	 public HttpStatus deleteCouponBycouponno(@PathVariable int couponno) { 
		 this.couponServ.deleteCouponBycouponno(couponno); 
	 return HttpStatus.OK; 
	 }
	 
	//Update Coupon by admin
		
	 @PutMapping("/update")
		public Coupons updateApartmentComplex(@RequestBody Coupons aupdate) {
		return couponServ.updateApartmentComplex(aupdate);
	
		}

	
}
