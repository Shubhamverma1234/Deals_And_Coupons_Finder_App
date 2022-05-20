package com.cg.model;

public class JWTResponse {

	private String jwtToken;

	public JWTResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public JWTResponse(String jwtToken) {
		super();
		this.jwtToken = jwtToken;
	}

	public String getJwtToken() {
		return jwtToken;
	}

	public void setJwtToken(String jwtToken) {
		this.jwtToken = jwtToken;
	}

	@Override
	public String toString() {
		return "JWTResponse [jwtToken=" + jwtToken + "]";
	}
	
}
