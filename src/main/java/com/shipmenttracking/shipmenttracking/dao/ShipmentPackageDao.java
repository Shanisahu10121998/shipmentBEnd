package com.shipmenttracking.shipmenttracking.dao;

import com.shipmenttracking.shipmenttracking.model.ShipmentPackage;
import com.shipmenttracking.shipmenttracking.repo.IShipmentPackageRepo;

public class ShipmentPackageDao {
    IShipmentPackageRepo shipmentPackageRepo;
    public ShipmentPackage createPackage(ShipmentPackage shipmentPackage){
        return shipmentPackageRepo.save(shipmentPackage);
    }
}
