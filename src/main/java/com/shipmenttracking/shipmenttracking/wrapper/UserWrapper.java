package com.shipmenttracking.shipmenttracking.wrapper;
import lombok.Data;
import org.springframework.stereotype.Component;
import com.shipmenttracking.shipmenttracking.model.User;

@Data
@Component
public class UserWrapper {

    private String firstName;
    private String lastName;
    private String contactNumber;
    private String email;
    private String address;
    public UserWrapper convertModelToWrapper(User user){
        UserWrapper userWrapper = new UserWrapper();
        userWrapper.setLastName(user.getLastName());
        userWrapper.setFirstName(user.getFirstName());
        userWrapper.setContactNumber(user.getContactNumber());
        userWrapper.setEmail(user.getEmail());
        userWrapper.setAddress(user.getAddress());
        return userWrapper;

    }
}
