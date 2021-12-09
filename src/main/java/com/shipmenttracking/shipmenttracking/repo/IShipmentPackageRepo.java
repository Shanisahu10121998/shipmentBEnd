package com.shipmenttracking.shipmenttracking.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.shipmenttracking.shipmenttracking.model.ShipmentPackage;

@Repository
public interface IShipmentPackageRepo extends JpaRepository<ShipmentPackage,Integer> {
    //@Query("SELECT sp FROM ShipmentPackage sp WHERE sp.")
   // public ShipmentPackage createPackage(ShipmentPackage shipmentPackage);

}
