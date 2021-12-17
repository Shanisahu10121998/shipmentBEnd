package com.shipmenttracking.shipmenttracking.service;

import com.shipmenttracking.shipmenttracking.model.User;
import com.shipmenttracking.shipmenttracking.wrapper.UserWrapper;

import java.security.Principal;

public interface IUserService {

    public UserWrapper userRegistration(User user) throws Exception;
    public UserWrapper getProfile(Principal principal) ;
}
