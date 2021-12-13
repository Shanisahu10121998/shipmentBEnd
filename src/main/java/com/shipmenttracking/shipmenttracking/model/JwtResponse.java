package com.shipmenttracking.shipmenttracking.model;
import lombok.Data;

@Data


public class JwtResponse {
	String token;
	String roleName;
	int userId;
	public JwtResponse(String token,String roleName,int userId){
		this.token=token;
		this.roleName=roleName;
this.userId=userId;
	}

	public JwtResponse(){

	}
	
}