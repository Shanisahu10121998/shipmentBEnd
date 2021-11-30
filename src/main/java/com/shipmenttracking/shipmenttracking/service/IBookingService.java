package com.shipmenttracking.shipmenttracking.service;
import com.shipmenttracking.shipmenttracking.model.Booking;
import com.shipmenttracking.shipmenttracking.wrapper.BookingWrapper;

public interface IBookingService {
    public BookingWrapper createBooking(BookingWrapper bookingWrapper);
    public Booking editShipment(Booking booking);
    public Booking getBookingInformationByTrackingId(String trackingId);
}
