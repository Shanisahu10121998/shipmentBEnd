package com.shipmenttracking.shipmenttracking.wrapper;
import com.shipmenttracking.shipmenttracking.model.Booking;
import lombok.Data;
import org.springframework.stereotype.Component;
import java.util.Date;

@Component
@Data
public class BookingWrapper {
    private int bookingId;
    private String senderName;
    private String senderAddress;
    private String senderMobileNumber;
    private String senderEmailId;
    private String senderCityName;
    private int senderPinCode;
    private String userInstruction;
    private Date bookingDate;
    private String receiverName;
    private String receiverAddress;
    private String receiverMobileNumber;
    private String receiverEmailId;
    private String receiverCityName;
    private int receiverPinCode;
    private String Status;
    private String Priority;
    private String trackingId;
    private String Category;

    public BookingWrapper convertModelToWrapper(Booking booking){
        BookingWrapper bookingWrapper = new BookingWrapper();
        bookingWrapper.setBookingId(booking.getBookingId());
        bookingWrapper.setSenderName(booking.getSenderName());
        bookingWrapper.setSenderAddress(booking.getSenderAddress());
        bookingWrapper.setSenderMobileNumber(booking.getSenderMobileNumber());
        bookingWrapper.setSenderEmailId(booking.getSenderEmailId());
        bookingWrapper.setSenderCityName(booking.getSenderCityName());
        bookingWrapper.setSenderPinCode(booking.getSenderPinCode());
        bookingWrapper.setUserInstruction(booking.getUserInstruction());
        bookingWrapper.setTrackingId(booking.getTrackingId());
        bookingWrapper.setBookingDate(booking.getBookingDate());
        bookingWrapper.setSenderAddress(booking.getSenderAddress());
        bookingWrapper.setReceiverName(booking.getReceiverName());
        bookingWrapper.setReceiverAddress(booking.getReceiverAddress());
        bookingWrapper.setReceiverMobileNumber(booking.getReceiverMobileNumber());
        bookingWrapper.setReceiverEmailId(booking.getReceiverEmailId());
        bookingWrapper.setReceiverCityName(booking.getReceiverCityName());
        bookingWrapper.setReceiverPinCode(booking.getReceiverPinCode());
        bookingWrapper.setStatus(booking.getStatus());
        bookingWrapper.setPriority(booking.getPriority());
        bookingWrapper.setReceiverAddress(booking.getReceiverAddress());
        bookingWrapper.setCategory(booking.getCategory());
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
        booking.setBookingDate(bookingWrapper.bookingDate);
        booking.setSenderAddress(bookingWrapper.getSenderAddress());
        booking.setReceiverName(bookingWrapper.getReceiverName());
        booking.setReceiverMobileNumber(bookingWrapper.getReceiverMobileNumber());
        booking.setReceiverEmailId(bookingWrapper.getReceiverEmailId());
        booking.setReceiverPinCode(bookingWrapper.getReceiverPinCode());
        booking.setReceiverCityName(bookingWrapper.getReceiverCityName());
        booking.setStatus(bookingWrapper.getStatus());
        booking.setPriority(bookingWrapper.getPriority());
        booking.setReceiverAddress(bookingWrapper.getReceiverAddress());
        booking.setCategory(bookingWrapper.getCategory());
        return booking;
    }
}
