package com.shipmenttracking.shipmenttracking.service.impl;

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
    IUserRepo userRepo;
    @Autowired
    UserWrapper userWrapper;
    @Autowired
    private IRoleRepo roleRepo;



    @Override

    public User userRegistration(User user) throws Exception{
        log.info("inside method userRegistration : {}", user);
        try {
        // apply null validation and vallid Role name
          Role dbRole = roleRepo.getRoleByName(user.getRole().getRoleName());
            log.info("inside method userRegistration dbRole: {}", dbRole);
          if(dbRole==null){
              throw new BusinessException("Role not found");
          }

         //  update existing role with user object
            user.setRole(dbRole);
            return userRepo.save(user);
        } catch (Exception e) {
            log.error("inside catch block", e.getMessage());
            throw new BusinessException(e.getMessage());
        }

    }

    @Override
    public UserWrapper getProfile(Integer id) {
        User user = userRepo.findById(id).get();
        UserWrapper userWrapperObj = userWrapper.convertModelToWrapper(user);
        return userWrapperObj;
    }

}
