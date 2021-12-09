package com.shipmenttracking.shipmenttracking.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Role {
    @GeneratedValue
    @Id
    @Column(name = "role_id")
    private int id;
    private String roleName;
}
