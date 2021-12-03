package com.shipmenttracking.shipmenttracking.model;
import lombok.Data;

@Data


public class JwtResponse {
	String token;
	public JwtResponse(String token){
		this.token=token;
	}

	public JwtResponse(){

	}
	
}