package com.shipmenttracking.shipmenttracking.service.impl;

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
    @Override

    public User userRegistration(User user) throws Exception{
        log.info("inside method userRegistration : {}", user);
        try {
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
