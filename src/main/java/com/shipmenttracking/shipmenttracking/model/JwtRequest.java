package com.shipmenttracking.shipmenttracking.model;

import lombok.Data;

@Data
public class JwtRequest {
	
	String username;
	String password;
	
	
	public JwtRequest() {
		super();
	}


	public JwtRequest(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	

}