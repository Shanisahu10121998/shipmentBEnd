package com.shipmenttracking.shipmenttracking.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.shipmenttracking.shipmenttracking.model.User;
import org.springframework.data.jpa.repository.Query;

public interface IUserRepo extends JpaRepository<User,Integer> {
	@Query("SELECT u FROM User u WHERE u.email = ?1")
	public User findByUserName(String username);
}
