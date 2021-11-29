package com.shipmenttracking.shipmenttracking.service.impl;

import com.shipmenttracking.shipmenttracking.dao.ShipmentPackageDao;
import com.shipmenttracking.shipmenttracking.model.ShipmentPackage;
import com.shipmenttracking.shipmenttracking.service.IShipmentPackageService;
import org.springframework.beans.factory.annotation.Autowired;

public class ShipmentPackageServiceImpl implements IShipmentPackageService {
    @Autowired
    ShipmentPackageDao shipmentPackageDao;
    @Override
    public ShipmentPackage createPackage(ShipmentPackage shipmentPackage) {
        return shipmentPackageDao.createPackage(shipmentPackage);
    }
}
