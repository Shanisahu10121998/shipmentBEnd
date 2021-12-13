package com.shipmenttracking.shipmenttracking.model;
import lombok.Data;

@Data


public class JwtResponse {
	String token;
	String roleName;
	public JwtResponse(String token,String roleName){
		this.token=token;
		this.roleName=roleName;

	}

	public JwtResponse(){

	}
	
}