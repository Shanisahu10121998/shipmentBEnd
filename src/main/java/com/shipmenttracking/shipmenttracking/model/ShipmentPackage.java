package com.shipmenttracking.shipmenttracking.model;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "SHIPMENT_PACKAGE")
public class ShipmentPackage {

    @Id
    @Column(name = "shipment_package_id_pk")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int packageId;

    @Column(name="package_name")
    private String packageName;

    @Column(name = "category",nullable = true)
    private String category;

/*
    @Column(name = "shipment_package_identifier")
    private String packageIdentifier;
*/

    @ManyToOne(cascade =CascadeType.ALL )
    @JoinColumn(name = "booking_id_fk")
    private Booking booking;


}
