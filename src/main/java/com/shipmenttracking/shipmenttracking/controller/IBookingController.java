package com.shipmenttracking.shipmenttracking.controller;

import com.shipmenttracking.shipmenttracking.model.Booking;

import com.shipmenttracking.shipmenttracking.wrapper.BookingWrapper;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RequestMapping("/booking")
public interface IBookingController
{
    @PostMapping(value = "/create",consumes = "application/json")
    public BookingWrapper createBooking(@RequestBody BookingWrapper bookingWrapper);
    @PutMapping(value = "/editShipment",consumes = "application/json")
    public Booking editShipment(@RequestBody Booking booking );
    @GetMapping(value = "/getTracking")
    @ApiOperation(value = "Finds Booking Information By Tracking Id",
            notes = "Provide a tracking id to look up specific booking details",
            response = Booking.class)
    public Booking getBookingInformationByTrackingId(@ApiParam(value = "Tracking Id value for the booking details you need to retrieve", readOnly = true)  String trackingId);
    @GetMapping(value = "/getAllBookingInfo")
    public List<BookingWrapper> getAllBookingInfo();
    @DeleteMapping("/delete/{bookingId}")
    public void deleteBookingById(@PathVariable Integer bookingId);

}
