package com.shipmenttracking.shipmenttracking.wrapper;

import com.shipmenttracking.shipmenttracking.model.Booking;
import com.shipmenttracking.shipmenttracking.model.User;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class BookingWrapper {
    private int bookingId;
    private String senderName;
    private String senderMobileNumber;
    private String senderEmailId;
    private String senderCityName;
    private int senderPinCode;
    private String userInstruction;

    private String receiverName;
    private String receiverMobileNumber;
    private String receiverEmailId;
    private String receiverCityName;
    private int receiverPinCode;
    private String Status;
    private String Priority;
    private String trackingId;


    public BookingWrapper convertModelToWrapper(Booking booking){
        BookingWrapper bookingWrapper = new BookingWrapper();
        bookingWrapper.setBookingId(booking.getBookingId());
        bookingWrapper.setSenderName(booking.getSenderName());
        bookingWrapper.setSenderMobileNumber(booking.getSenderMobileNumber());
        bookingWrapper.setSenderEmailId(booking.getSenderEmailId());
        bookingWrapper.setSenderCityName(booking.getSenderCityName());
        bookingWrapper.setSenderPinCode(booking.getSenderPinCode());
        bookingWrapper.setUserInstruction(booking.getUserInstruction());
        bookingWrapper.setTrackingId(booking.getTrackingId());

        bookingWrapper.setReceiverName(booking.getReceiverName());
        bookingWrapper.setReceiverMobileNumber(booking.getReceiverMobileNumber());
        bookingWrapper.setReceiverEmailId(booking.getReceiverEmailId());
        bookingWrapper.setReceiverCityName(booking.getReceiverCityName());
        bookingWrapper.setReceiverPinCode(booking.getReceiverPinCode());
        bookingWrapper.setStatus(booking.getStatus());
        bookingWrapper.setPriority(booking.getPriority());
        return bookingWrapper;

    }

    public Booking convertWrapperToModel(BookingWrapper bookingWrapper){
        Booking booking = new Booking();
        booking.setSenderName(bookingWrapper.getSenderName());
        booking.setSenderMobileNumber(bookingWrapper.getSenderMobileNumber());
        booking.setSenderEmailId(bookingWrapper.getSenderEmailId());
        booking.setSenderCityName(bookingWrapper.getSenderCityName());
        booking.setSenderPinCode(bookingWrapper.getSenderPinCode());
        booking.setUserInstruction(bookingWrapper.getUserInstruction());
        booking.setTrackingId(bookingWrapper.getTrackingId());

        booking.setReceiverName(bookingWrapper.getReceiverName());
        booking.setReceiverMobileNumber(bookingWrapper.getReceiverMobileNumber());
        booking.setReceiverEmailId(bookingWrapper.getReceiverEmailId());
        booking.setReceiverPinCode(bookingWrapper.getReceiverPinCode());
        booking.setReceiverCityName(bookingWrapper.getReceiverCityName());
        booking.setStatus(bookingWrapper.getStatus());
        booking.setPriority(bookingWrapper.getPriority());
        return booking;
    }




}
