package com.shipmenttracking.shipmenttracking.controller;

import com.shipmenttracking.shipmenttracking.wrapper.UserWrapper;
import org.springframework.web.bind.annotation.*;
import com.shipmenttracking.shipmenttracking.model.User;

@RequestMapping("/registration")
public interface IUserController {

    @PostMapping(value = "/register",consumes = "application/json")
    public User userRegistration(@RequestBody User user) throws Exception;
    @GetMapping("/getProfile")
    public UserWrapper getProfile(@PathVariable Integer id);

}

