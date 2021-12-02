package com.shipmenttracking.shipmenttracking.service.impl;

import com.shipmenttracking.shipmenttracking.dao.UserDao;
import com.shipmenttracking.shipmenttracking.model.Role;
import com.shipmenttracking.shipmenttracking.repo.IRoleRepo;
import com.shipmenttracking.shipmenttracking.repo.IUserRepo;
import com.shipmenttracking.shipmenttracking.exception.BusinessException;
import com.shipmenttracking.shipmenttracking.wrapper.UserWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.shipmenttracking.shipmenttracking.model.User;
import com.shipmenttracking.shipmenttracking.service.IUserService;

@Service
@Slf4j
public class UserServiceImpl implements IUserService {
   @Autowired
   UserDao userDao;
    @Autowired
    UserWrapper userWrapper;



    @Override
    public User userRegistration(User user) throws Exception{
        setUserRole(user);
      try {
           User user1=userDao.getUserByUsername(user.getUsername());

           if(user1!=null){
               throw new RuntimeException("user with " + user.getEmail() + " Email id already exist");
           }
            return userDao.userRegistration(user);
        } catch (Exception ex) {
            log.info("inside catch block", ex.getMessage());
            throw new RuntimeException(ex.getMessage());
        }

    }

    private void setUserRole(User user) {
        log.info("inside method setUserRole : {}", user);
        Role role = new Role();
        role.setId(2);
        role.setRoleName("User");
        user.setRole(role);
    }

    @Override
    public UserWrapper getProfile(Integer id) {
        User user = userDao.getProfile(id);
        UserWrapper userWrapperObj = userWrapper.convertModelToWrapper(user);
        return userWrapperObj;
    }

}
