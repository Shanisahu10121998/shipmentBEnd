package com.shipmenttracking.shipmenttracking.controller.impl;

import com.shipmenttracking.shipmenttracking.controller.IShipmentPackageController;
import com.shipmenttracking.shipmenttracking.model.ShipmentPackage;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShipmentPackageControllerImpl implements IShipmentPackageController {
    @Override
    public ShipmentPackage createPackage(ShipmentPackage shipmentPackage) {
        return null;
    }
}
