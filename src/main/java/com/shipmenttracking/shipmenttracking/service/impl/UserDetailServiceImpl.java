package com.shipmenttracking.shipmenttracking.service.impl;

import com.shipmenttracking.shipmenttracking.model.User;
import com.shipmenttracking.shipmenttracking.repo.IUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

import javax.swing.plaf.synth.SynthTextAreaUI;

@Slf4j
@Service
public class UserDetailServiceImpl implements UserDetailsService{
	
	@Autowired
	private IUserRepo userRepository;

	@Override
	public User loadUserByUsername(String username) throws UsernameNotFoundException {
		
		log.info("inside @class UserDetailServiceImpl @method  loadUserByUsername username : {}",username);
		
		User user = this.userRepository.findByUserName(username);
		//System.out.println("In User Details ServiceIMPL"+user.getRole());
		
		if(user == null) {
			throw new UsernameNotFoundException("No user found !! ");
		}
		
		return user;
	}

}
