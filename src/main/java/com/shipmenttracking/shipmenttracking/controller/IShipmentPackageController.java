package com.shipmenttracking.shipmenttracking.controller;

import com.shipmenttracking.shipmenttracking.model.ShipmentPackage;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
public interface IShipmentPackageController {


    @PostMapping(value = "/createPackage", consumes = "application/json")

        public ShipmentPackage createPackage(@RequestBody  ShipmentPackage shipmentPackage);

}
