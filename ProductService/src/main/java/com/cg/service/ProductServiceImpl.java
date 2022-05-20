package com.cg.service;

import java.util.List;
import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.exception.NameNotFoundException;
import com.cg.exception.ProductAlreadyExistsException;
import com.cg.exception.ProductIdNotFound;

import com.cg.model.Product;
import com.cg.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductRepository prodRepo;
	
	
	//public DealsServiceImpl(DealsRepository agenRepo) {
		//super();
	//	this.dealRepo = dealRepo;
	//}
	//add product using this method 
 @Override
	public Product addProducts(Product prod)throws ProductAlreadyExistsException{
	 if(prodRepo.existsById(prod.getProductno())) {
		
		throw new ProductAlreadyExistsException();
	}

	Product saveddeal = prodRepo.save(prod);
	return saveddeal;
}
	
	
//@Override
//	public void deleteAgencyByagenno(int agenno) {
//		// TODO Auto-generated method stub
//		agenRepo.deleteById(agenno);
//	}
 
  //get all products using this method 
	@Override
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return (List<Product>) prodRepo.findAll();
	}
  //get product using the product name
	@Override
	public Product getProductDataByname(String pname) throws NameNotFoundException{
		Optional<Product> dealDB = this.prodRepo.findBypname(pname);
		if(dealDB.isEmpty())
		{
			throw new NameNotFoundException();
	 
		}
		
		
		 return dealDB.get();
		
	}
	
	//get product using the product id	
	@Override
	public Product getProductDataById(int productno)throws ProductIdNotFound {
		Optional<Product> popDb = this.prodRepo.findById(productno);

	    if (popDb.isPresent()) {
	    	
	        return popDb.get();
	    } 
	    else
	    {
	    	throw new ProductIdNotFound();
	    }
	}
	
//	public Deals updateApartmentComplex(Deals aptu) {
//		Deals record;
//		Optional<Deals> opt=agenRepo.findById(aptu.getAgenno());
//		if(opt.isPresent()) {
//		record=opt.get();
//		record.setAname(aptu.getAname());
//		agenRepo.save(record);
//		}else {
//		return new Deals();
//		}
//		return record;
//}
}
