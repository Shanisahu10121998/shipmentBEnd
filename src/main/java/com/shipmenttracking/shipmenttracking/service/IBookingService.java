package com.shipmenttracking.shipmenttracking.service;
import com.shipmenttracking.shipmenttracking.model.Booking;

public interface IBookingService {
    public Booking createBooking(Booking booking);
    public Booking editShipment(Booking booking);
    public Booking getBookingInformationByTrackingId(String trackingId);
}
