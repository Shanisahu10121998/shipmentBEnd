package com.shipmenttracking.shipmenttracking.service.impl;

import com.shipmenttracking.shipmenttracking.dao.BookingDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.shipmenttracking.shipmenttracking.model.Booking;
import com.shipmenttracking.shipmenttracking.repo.IBookingRepo;
import com.shipmenttracking.shipmenttracking.service.IBookingService;

import java.util.Random;

@Service
public class BookingServiceImpl implements IBookingService {
    @Autowired
    private BookingDao bookingDao;

    @Override
    public Booking createBooking(Booking booking) {
        booking.setStatus(String.valueOf(Booking.Status.BOOKED));
        String trackingId = null;
        trackingId  ="trackingId";
        trackingId = isTrackingIdPresent(trackingId);
        booking.setTrackingId(trackingId);
        return bookingDao.createBooking(booking);
    }

    @Override
    public Booking editShipment(Booking booking) {
        Booking booking1 = bookingDao.getBookingById(booking.getBookingId());
        booking1.setReceiverCityName(booking.getReceiverCityName());
        booking1.setReceiverEmailId(booking.getReceiverEmailId());
        booking1.setReceiverName(booking.getReceiverName());
        booking1.setReceiverMobileNumber(booking.getReceiverMobileNumber());
        booking1.setReceiverStateName(booking.getReceiverStateName());

        return bookingDao.createBooking(booking1);
    }

    @Override
    public Booking getBookingInformationByTrackingId(Integer id) {

        return bookingDao.getBookingInformationByTrackingId(id);
    }

    private String generateUniqueId(){
        Random r = new Random();
        int numbers = 1000000 + (int)(r.nextFloat() * 8999000);
        return String.valueOf(numbers);
    }
    private String isTrackingIdPresent(String trackingId){
        String sTracking = trackingId;
        Booking booking1 = bookingDao.checkTrackingId(trackingId);
        if(booking1==null){
            return sTracking;
        }
        else{
            sTracking = generateUniqueId();
            isTrackingIdPresent(sTracking);
        }
        return sTracking;
    }
}
