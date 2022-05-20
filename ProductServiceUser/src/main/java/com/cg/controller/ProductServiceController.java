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

import com.cg.exception.NameNotFoundException;
import com.cg.exception.ProductAlreadyExistsException;
import com.cg.exception.ProductIdNotFound;

import com.cg.model.Product;

import com.cg.service.ProductService;

@RestController
@RequestMapping("/api/v2")
public class ProductServiceController {
	@Autowired
	private ProductService prodServ;


	//get all products 
	@GetMapping("/prods")
	public ResponseEntity<List<Product>> getAllProducts(){
        return new ResponseEntity<List<Product>>((List<Product>)prodServ.getAllProducts(),HttpStatus.OK);
    }
	
	
	//get product by product name 
	 @GetMapping("/getproduct/{pname}")
	  public ResponseEntity < Product > getProductDataByname(@PathVariable String pname)throws NameNotFoundException  {
	        return ResponseEntity.ok().body(prodServ.getProductDataByname(pname));
	    }
	
	 
	  //get product by product id
	  @GetMapping("/getproductid/{id}")
	    public ResponseEntity < Product > getProductDataById(@PathVariable int id) throws ProductIdNotFound {
	        return ResponseEntity.ok().body(prodServ.getProductDataById(id));
	    }

	
}
