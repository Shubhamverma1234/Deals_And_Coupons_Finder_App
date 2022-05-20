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

import com.cg.exception.DealsAlreadyExistsException;
import com.cg.exception.DealsIdNotFound;
import com.cg.exception.NameNotFoundException;
import com.cg.model.Deals;

import com.cg.service.DealsService;

@RestController
@RequestMapping("/api/d1")
public class DealsServiceController {
	@Autowired
	private DealsService dealServ;

	@Autowired
	public DealsServiceController(DealsService dealServ) {
		this.dealServ = dealServ;
	}
	//Adding Deals by post mapping
	@PostMapping("/deal")
	 public ResponseEntity<Deals> addAgency(@RequestBody Deals deal )throws DealsAlreadyExistsException{
        Deals saveddeal = dealServ.addDeals(deal);
       return new ResponseEntity<>(saveddeal, HttpStatus.CREATED);
   }
	//get deals by dealid 
	 @GetMapping("/getdealid/{id}")
	    public ResponseEntity < Deals > getDealsDataById(@PathVariable int id) throws DealsIdNotFound {
	        return ResponseEntity.ok().body(dealServ.getDealsDataById(id));
	    }
	 //get all deals 
	@GetMapping("/deals")
	public ResponseEntity<List<Deals>> getAllDeals(){
        return new ResponseEntity<List<Deals>>((List<Deals>)dealServ.getAllDeals(),HttpStatus.OK);
    }
	//get deals by deal name
	   @GetMapping("/getdeals/{dname}")
	    public ResponseEntity < Deals > getDealsDataByname(@PathVariable String dname) throws NameNotFoundException {
	       
		   return ResponseEntity.ok().body(dealServ.getDealsDataByname(dname));
	    }
//	@DeleteMapping("/agen/{agenno}")
//	public ResponseEntity<Void> deleteEmployeeById(@PathVariable int agenno){
//        agenServ.deleteAgencyByagenno(agenno);
//        return ResponseEntity.noContent().build();
//    }
//	
//	@PutMapping("/update")
//	public Deals updateApartmentComplex(@RequestBody Deals aupdate) {
//	return agenServ.updateApartmentComplex(aupdate);
//
//	}
	
}
