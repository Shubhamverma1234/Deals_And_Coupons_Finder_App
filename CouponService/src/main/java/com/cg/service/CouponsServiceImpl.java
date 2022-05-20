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
	
	

	//this method adds the coupons
 @Override
	public Coupons addCoupon(Coupons coupon)throws CouponAlreadyExistsException{
	 if(couponRepo.existsById(coupon.getCouponno())) {
			
			throw new CouponAlreadyExistsException();
		}
	
		Coupons saveddeal = couponRepo.save(coupon);
		return saveddeal;
	}
	
 //this method delete the coupons
@Override
	public void deleteCouponBycouponno(int couponno) {
		// TODO Auto-generated method stub
		couponRepo.deleteById(couponno);
	}
//this method get all coupons
	@Override
	public List<Coupons> getAllCoupons() {
		// TODO Auto-generated method stub
		return (List<Coupons>) couponRepo.findAll();
	}
//this method get the coupon by name
	@Override
	public Coupons getCouponsDataByname(String cname) throws NameNotFoundException {
		Optional<Coupons> couponDB = this.couponRepo.findBycname(cname);
		if(couponDB.isPresent())
		{
		
	  return couponDB.get();
		}
		else
		{
			throw new NameNotFoundException();
		}
	}
	//this method get the coupon by id
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
//this method update the coupon details
	public Coupons updateApartmentComplex(Coupons aptu) {
		Coupons record;
		Optional<Coupons> opt=couponRepo.findById(aptu.getCouponno());
		if(opt.isPresent()) {
		record=opt.get();
		record.setCname(aptu.getCname());
		couponRepo.save(record);
		}else {
		return new Coupons();
		}
		return record;
}
}
