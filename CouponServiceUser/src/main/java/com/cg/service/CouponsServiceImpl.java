package com.cg.service;


import java.util.List;
import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.exception.CouponAlreadyExistsException;
import com.cg.exception.CouponIdNotFound;
import com.cg.exception.NameNotFoundException;
import com.cg.model.Coupons;

import com.cg.repository.CouponsRepository;

@Service
public class CouponsServiceImpl implements CouponsService {
	@Autowired
	private CouponsRepository couponRepo;
	
	
	//Add coupon on this method and also implement coupons already exception
 @Override
	public Coupons addCoupon(Coupons coupon)throws CouponAlreadyExistsException{
	 if(couponRepo.existsById(coupon.getCouponno())) {
			
			throw new CouponAlreadyExistsException();
		}
	
		Coupons saveddeal = couponRepo.save(coupon);
		return saveddeal;
	}
	
// get all coupons on this method 
	@Override
	public List<Coupons> getAllCoupons() {
		// TODO Auto-generated method stub
		return (List<Coupons>) couponRepo.findAll();
	}
//get coupons by name 
	@Override
	public Coupons getCouponsDataByname(String cname) throws NameNotFoundException {
		Optional<Coupons> dealDB = this.couponRepo.findBycname(cname);
		if(dealDB.isPresent())
		{
		
	  return dealDB.get();
		}
		else
		{
			throw new NameNotFoundException();
		}
	}
	//get coupon by id
	@Override
	public Coupons getCouponDataById(int couponno)throws CouponIdNotFound {
		Optional<Coupons> popDb = this.couponRepo.findById(couponno);

	    if (popDb.isPresent()) {
	    	
	        return popDb.get();
	    } 
	    else
	    {
	    	throw new CouponIdNotFound();
	    }
	}
}


