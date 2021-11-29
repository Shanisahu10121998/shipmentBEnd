package com.shipmenttracking.shipmenttracking.controller;

import com.shipmenttracking.shipmenttracking.model.Booking;
import org.springframework.web.bind.annotation.*;

public interface IBookingController {
    @PostMapping(value = "create",consumes = "application/json")
    public Booking createBooking(@RequestBody Booking booking);
    @PutMapping(value = "editShipment",consumes = "application/json")
    public Booking editShipment(@RequestBody Booking booking );
    @GetMapping(value = "/getTracking")
    public Booking getBookingInformationByTrackingId(Integer id);
}
