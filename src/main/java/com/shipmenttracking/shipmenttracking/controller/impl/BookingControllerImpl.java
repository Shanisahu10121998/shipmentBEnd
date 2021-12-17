package com.shipmenttracking.shipmenttracking.controller.impl;
import com.shipmenttracking.shipmenttracking.controller.IBookingController;
import com.shipmenttracking.shipmenttracking.exception.BusinessException;
import com.shipmenttracking.shipmenttracking.service.IBookingService;
import com.shipmenttracking.shipmenttracking.wrapper.BookingWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.shipmenttracking.shipmenttracking.model.Booking;
import java.security.Principal;
import java.util.List;

@Slf4j
@RestController
public class BookingControllerImpl implements IBookingController {
    @Autowired
    private IBookingService bookingService;

    @Override
    public BookingWrapper createBooking(BookingWrapper bookingWrapper, Principal principal) {
        return bookingService.createBooking(bookingWrapper,principal);
    }

    @Override
    public Booking editShipment(Booking booking) {

        return bookingService.editShipment(booking);
    }

    @Override
    public Booking  getBookingInformationByTrackingId(String trackingId) {
       try {
           return bookingService.getBookingInformationByTrackingId(trackingId);
       }catch (Exception ex){
           log.info("Error Message :{} ",ex.getMessage());

           throw new BusinessException(ex.getMessage());
       }
    }
    @Override
    public List<BookingWrapper> getAllBookingInfo() {
        return bookingService.getAllBookingInfo();
    }

    @Override
    public void deleteBookingById(Integer bookingId) {
        bookingService.deleteBookingById(bookingId);
    }

    @Override
    public List<BookingWrapper> getAllBookingInfoByUserName(Principal principal) {
        return bookingService.getAllBookingInfoByUserName(principal);
    }
    @Override
    public Booking editStatus(int bookingId, String status) {
        Booking.Status statusValue = Enum.valueOf(Booking.Status.class, status);

        return bookingService.editStatus(bookingId,statusValue);
    }
}
