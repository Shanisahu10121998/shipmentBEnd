package com.shipmenttracking.shipmenttracking.service;

import com.shipmenttracking.shipmenttracking.model.User;
import com.shipmenttracking.shipmenttracking.wrapper.UserWrapper;

public interface IUserService {

    public User userRegistration(User user) throws Exception;
    public UserWrapper getProfile(Integer id) ;
}
