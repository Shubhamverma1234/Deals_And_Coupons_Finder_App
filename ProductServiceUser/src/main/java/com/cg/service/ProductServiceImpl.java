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
	
	//Add product by this method
 @Override
	public Product addProducts(Product prod)throws ProductAlreadyExistsException{
	 if(prodRepo.existsById(prod.getProductno())) {
		
		throw new ProductAlreadyExistsException();
	}

	Product saveddeal = prodRepo.save(prod);
	return saveddeal;
}
	
//get all product 
	@Override
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return (List<Product>) prodRepo.findAll();
	}
	
// get product by product name
	@Override
	public Product getProductDataByname(String pname) throws NameNotFoundException{
		Optional<Product> dealDB = this.prodRepo.findBypname(pname);
		if(dealDB.isEmpty())
		{
			throw new NameNotFoundException();
	 
		}
		
		
		 return dealDB.get();
		
	}
		
	//get product by product id
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
	

}
