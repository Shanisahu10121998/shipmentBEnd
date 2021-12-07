package com.shipmenttracking.shipmenttracking.controller.impl;

import com.shipmenttracking.shipmenttracking.exception.BusinessException;
import com.shipmenttracking.shipmenttracking.service.impl.UserDetailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.shipmenttracking.shipmenttracking.config.JwtUtils;

import com.shipmenttracking.shipmenttracking.model.JwtRequest;
import com.shipmenttracking.shipmenttracking.model.JwtResponse;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@CrossOrigin("*")
public class AuthenticateController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private UserDetailServiceImpl userDetailService;

	@Autowired
	private JwtUtils jwtUtils;

	/**
	 * this method generate token
	 * 
	 * @param jwtRequest the request object username and password
	 * @return token 
	 * @throws Exception
	 */
	@PostMapping("/user/login")
	public ResponseEntity<?> generateToken(@RequestBody JwtRequest jwtRequest) throws Exception {
		log.info("@class {} @method name {}", "AuthenticateController", "generateToken");
		UserDetails userDetails = this.userDetailService.loadUserByUsername(jwtRequest.getUsername());
		try {
			authenticate(jwtRequest.getUsername(), jwtRequest.getPassword());
		} catch (UsernameNotFoundException e) {
			log.error("error occurred generateToken", e.getMessage());
			throw new Exception("User not found");
		}
		///////Authenticate
		String token = this.jwtUtils.generateToken(userDetails);

		return ResponseEntity.ok(new JwtResponse(token));

	}

	/**
	 * this method authenticate user
	 * 
	 * @param username the username to search
	 * @param password the password to search
	 */
	private void authenticate(String username, String password) throws Exception {
		log.info("@class {} @method name {}", "AuthenticateController", "authenticate");
		try {

			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException e) {
			log.error("error occurred authenticate", e.getMessage());
			throw new DisabledException("User Disabled "+e.getMessage());
		}catch (BadCredentialsException e){
			throw new Exception("Invalid Credentials "+e.getMessage());
		}
	}

	/**
	 * this method search current logged in user
	 * 
	 * @param principal the Principal object
	 * @return
	 * @throws Exception
	 */

}
