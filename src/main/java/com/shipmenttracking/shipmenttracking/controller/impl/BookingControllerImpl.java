package com.shipmenttracking.shipmenttracking.controller.impl;

import com.shipmenttracking.shipmenttracking.controller.IBookingController;
import com.shipmenttracking.shipmenttracking.service.IBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.shipmenttracking.shipmenttracking.model.Booking;

@RestController
public class BookingControllerImpl implements IBookingController {
    @Autowired
    private IBookingService bookingService;

    @Override
    public Booking createBooking(Booking booking) {
        return bookingService.createBooking(booking);
    }

    @Override
    public Booking editShipment(Booking booking) {

        return bookingService.editShipment(booking);
    }

    @Override
    public Booking getBookingInformationByTrackingId(Integer id) {
        return bookingService.getBookingInformationByTrackingId(id);
    }
}
