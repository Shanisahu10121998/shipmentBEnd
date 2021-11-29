package com.shipmenttracking.shipmenttracking.model;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "SHIPMENT_PACKAGE")
public class ShipmentPackage {

    enum type{
        BUSINESS,PERSONAL;
    }
    enum category{
        ELECTRONICS,MEDICAL, HOUSEHOLD,DOCUMENT,VEHICLE,LARGE_CARGO;
    }

    @Id
    @Column(name = "shipment_package_id_pk")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int packageId;
    @Column(name = "shipment_package_identifier")
    private String packageIdentifier;

    @ManyToOne(cascade =CascadeType.ALL )
    @JoinColumn(name = "booking_id_fk")
    private Booking booking;


}
