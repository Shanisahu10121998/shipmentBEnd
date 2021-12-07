package com.shipmenttracking.shipmenttracking.service.impl;

import com.shipmenttracking.shipmenttracking.dao.BookingDao;
import com.shipmenttracking.shipmenttracking.dao.UserDao;
import com.shipmenttracking.shipmenttracking.exception.BusinessException;
import com.shipmenttracking.shipmenttracking.wrapper.BookingWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.shipmenttracking.shipmenttracking.model.Booking;
import com.shipmenttracking.shipmenttracking.repo.IBookingRepo;
import com.shipmenttracking.shipmenttracking.service.IBookingService;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
@Slf4j
public class BookingServiceImpl implements IBookingService {
    @Autowired
    private BookingDao bookingDao;

    @Autowired
    private BookingWrapper bookingWrapperObj;

    @Autowired
    UserDao userDao;

    @Override
    public BookingWrapper createBooking(BookingWrapper bookingWrapper, Principal principal) {
        bookingWrapper.setStatus(String.valueOf(Booking.Status.BOOKED));
        String trackingId = null;
        trackingId  ="trackingId";
        trackingId = isTrackingIdPresent(trackingId);
        bookingWrapper.setTrackingId(trackingId);
        Booking booking = bookingWrapperObj.convertWrapperToModel(bookingWrapper);
        booking.setUser(userDao.getUserByUsername(principal.getName()));
        Booking booking1 = bookingDao.createBooking(booking);
        return bookingWrapper.convertModelToWrapper(booking1);
    }

    @Override
    public Booking  editShipment(Booking booking) {
        Booking booking1 = bookingDao.getBookingById(booking.getBookingId());
        booking1.setReceiverCityName(booking.getReceiverCityName());
        booking1.setReceiverEmailId(booking.getReceiverEmailId());
        booking1.setReceiverName(booking.getReceiverName());
        booking1.setReceiverMobileNumber(booking.getReceiverMobileNumber());


        return bookingDao.createBooking(booking1);
    }

    @Override
    public Booking getBookingInformationByTrackingId(String trackingId) {
        try {
            Booking booking = bookingDao.getBookingInformationByTrackingId(trackingId);
            log.info("inside service: {}",booking);
            if (booking == null) {
                throw new BusinessException("Booking not fount with " + trackingId + " tracking Id");
            }
            return booking;
        } catch (Exception ex) {
            log.info("inside service: {}",ex);
            throw new BusinessException(ex.getMessage());
        }
    }

    @Override
    public List<BookingWrapper> getAllBookingInfo() {
        List<Booking> bookingList=bookingDao.getAllBookingInfo();
        List<BookingWrapper> bookingWrappers = new ArrayList<>();
        bookingWrappers = bookingList.stream().map(booking->{
           return  bookingWrapperObj.convertModelToWrapper(booking);
        }).collect(Collectors.toList());
        return bookingWrappers;
    }

    @Override
    public void deleteBookingById(Integer id) {

        bookingDao.deleteBookingById(id);
    }

    @Override
    public List<BookingWrapper> getAllBookingInfoByUserName(Principal principal) {

        List<Booking> bookingList=bookingDao.getAllBookingInfoByUserName(principal.getName());
        List<BookingWrapper> bookingWrappers = new ArrayList<>();
        bookingWrappers = bookingList.stream().map(booking->{
            return  bookingWrapperObj.convertModelToWrapper(booking);
        }).collect(Collectors.toList());
        return bookingWrappers;
    }

    private String generateUniqueId(){
        Random r = new Random();
        int numbers = 1000000 + (int)(r.nextFloat() * 8999000);
        return String.valueOf(numbers);
    }
    private String isTrackingIdPresent(String trackingId){
        String isTracking = trackingId;
        Booking booking1 = bookingDao.checkTrackingId(trackingId);
        if(booking1==null){
            return isTracking;
        }
        else{
            isTracking = generateUniqueId();
            isTrackingIdPresent(isTracking);
        }
        return isTracking;
    }
}
