package com.shipmenttracking.shipmenttracking.controller;

import com.shipmenttracking.shipmenttracking.wrapper.UserWrapper;
import org.springframework.web.bind.annotation.*;
import com.shipmenttracking.shipmenttracking.model.User;

import java.security.Principal;

@RequestMapping("/user")
public interface IUserController {

    @PostMapping(value = "/register",consumes = "application/json")
    public UserWrapper userRegistration(@RequestBody User user) throws Exception;
    @GetMapping("/getProfile")
    public UserWrapper getProfile(Principal principal);

}

