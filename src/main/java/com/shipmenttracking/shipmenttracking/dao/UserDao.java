package com.shipmenttracking.shipmenttracking.dao;

import com.shipmenttracking.shipmenttracking.model.User;
import com.shipmenttracking.shipmenttracking.repo.IUserRepo;
import com.shipmenttracking.shipmenttracking.wrapper.UserWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserDao {
    @Autowired
    private IUserRepo userRepo;
    public User userRegistration(User user) throws Exception{
        return userRepo.save(user);
    }
    public User getUserByUsername(String username){
        return  userRepo.findByUserName(username);
    }
    public User getProfile(Integer id) {
        return userRepo.getById(id);
    }
}
