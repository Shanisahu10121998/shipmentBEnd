package com.shipmenttracking.shipmenttracking.controller.impl;

import com.shipmenttracking.shipmenttracking.controller.IUserController;
import com.shipmenttracking.shipmenttracking.exception.BusinessException;
import com.shipmenttracking.shipmenttracking.wrapper.UserWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import com.shipmenttracking.shipmenttracking.model.User;
import com.shipmenttracking.shipmenttracking.service.IUserService;

import java.util.Random;

@Slf4j
@RestController
public class UserControllerImpl implements IUserController {

    @Autowired
    private IUserService userService;


    @Override
    public User userRegistration(User user) throws Exception {
        log.info("inside method userRegistration ");
        try{
            return userService.userRegistration(user);
        }
        catch (Exception ex){

            throw new Exception(ex.getMessage());
        }
    }

    @Override
    public UserWrapper getProfile(Integer id) {
        return userService.getProfile(id);
    }
}



