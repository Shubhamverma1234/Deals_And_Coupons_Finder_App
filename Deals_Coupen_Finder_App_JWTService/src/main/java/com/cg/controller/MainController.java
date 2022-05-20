package com.cg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.exception.Invalid_CredentialsException;
import com.cg.model.JWTResponse;
import com.cg.model.Users;
import com.cg.repository.UserRepositiory;
import com.cg.service.UserAuthentication;
import com.cg.utility.JWTUtility;


@RequestMapping("/api/jwt")
@RestController
public class MainController {

	@Autowired
	private JWTUtility jwtUtility;
	
	@Autowired
	private UserRepositiory userRepositiory;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private UserAuthentication userService;
	
	@PostMapping("/register")
	public ResponseEntity<?> addUser(@RequestBody Users user) {
		String usrName=user.getUserName();
		String pswrd=user.getPassWord();
		Users usr=new Users();
		usr.setUserName(usrName);
		usr.setPassWord(pswrd);
		userRepositiory.save(usr);
		return new ResponseEntity<>("Succesfull Registration"+usr, HttpStatus.OK);
		
	}
	
//	@GetMapping("/get")
//	public ResponseEntity<List<Users>> getallApartmentComplex(){
//		return new ResponseEntity<List<Users>>((List<Users>)userRepositiory.findAll(),HttpStatus.OK);
//	}
	
	@PostMapping("/authenticate")
	public JWTResponse authenticate(@RequestBody Users jwtRequest) throws Invalid_CredentialsException {
		try {
		authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(
						jwtRequest.getUserName(), jwtRequest.getPassWord()));
		}
		catch(BadCredentialsException e) {
			throw new Invalid_CredentialsException();
		}
		final UserDetails userDetails
			= userService.loadUserByUsername(jwtRequest.getUserName());
		
		final String token=
				jwtUtility.generateToken(userDetails);
		
		return new JWTResponse(token);
	}
}
