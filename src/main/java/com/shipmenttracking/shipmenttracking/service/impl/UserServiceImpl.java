package com.shipmenttracking.shipmenttracking.service.impl;

import com.shipmenttracking.shipmenttracking.dao.UserDao;
import com.shipmenttracking.shipmenttracking.model.Role;
import com.shipmenttracking.shipmenttracking.wrapper.UserWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.shipmenttracking.shipmenttracking.model.User;
import com.shipmenttracking.shipmenttracking.service.IUserService;

import java.security.Principal;

@Service
@Slf4j
public class UserServiceImpl implements IUserService {
   @Autowired
   UserDao userDao;
    @Autowired
    UserWrapper userWrapper;

    @Override
    public UserWrapper userRegistration(User user) throws Exception{
        setUserRole(user);
      try {
           User user1=userDao.getUserByUsername(user.getUsername());

           if(user1!=null){
               throw new RuntimeException("user with " + user.getEmail() + " Email id already exist");
           }
            User user2= userDao.userRegistration(user);
           UserWrapper userWrapper1 =userWrapper.convertModelToWrapper(user2);
          return userWrapper1;
        } catch (Exception ex) {
            log.info("inside catch block", ex.getMessage());
            throw new RuntimeException(ex.getMessage());
        }

    }

    private void setUserRole(User user) {
        log.info("inside method setUserRole : {}", user);
        Role role = new Role();
        role.setRoleId(2);
        role.setRoleName("User");
        user.setRole(role);
    }

    @Override
    public UserWrapper getProfile(Principal principal) {
        User user = userDao.getUserByUsername(principal.getName());
        UserWrapper userWrapperObj = userWrapper.convertModelToWrapper(user);
        return userWrapperObj;
    }

}
