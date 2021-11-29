package com.shipmenttracking.shipmenttracking.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class Role {
    @GeneratedValue
    @Id
    private int id;
    private String roleName;
}
