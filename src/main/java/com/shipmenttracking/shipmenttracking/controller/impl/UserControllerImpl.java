package com.shipmenttracking.shipmenttracking.controller.impl;
import com.shipmenttracking.shipmenttracking.controller.IUserController;
import com.shipmenttracking.shipmenttracking.wrapper.UserWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RestController;
import com.shipmenttracking.shipmenttracking.model.User;
import com.shipmenttracking.shipmenttracking.service.IUserService;
import java.security.Principal;

@Slf4j
@RestController
public class UserControllerImpl implements IUserController {

    @Autowired
    private IUserService userService;

    @Autowired private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserWrapper userRegistration(User user) throws Exception {
        log.info("inside method userRegistration ");
        try{
            //for password encoding
           user.setPassword(bCryptPasswordEncoder. encode(user.getPassword()));
            return userService.userRegistration(user);
        }
        catch (Exception ex){

            throw new Exception(ex.getMessage());
        }
    }

    @Override
    public UserWrapper getProfile(Principal principal) {
        return userService.getProfile(principal);
    }
}



