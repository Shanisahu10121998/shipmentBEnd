package com.shipmenttracking.shipmenttracking.repo;

import com.shipmenttracking.shipmenttracking.model.Role;
import com.shipmenttracking.shipmenttracking.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IRoleRepo extends JpaRepository<Role,Integer> {

    @Query("SELECT r FROM Role r WHERE r.roleName = ?1")
    public Role getRoleByName(String roleName);
}
