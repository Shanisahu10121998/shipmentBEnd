package com.shipmenttracking.shipmenttracking.dao;
import com.shipmenttracking.shipmenttracking.model.Booking;
import com.shipmenttracking.shipmenttracking.repo.IBookingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class BookingDao {
    @Autowired
    private IBookingRepo bookingRepo;

    public Booking createBooking(Booking booking) {
        return bookingRepo.save(booking);
    }
    public Booking getBookingById(int bookingId){
        return bookingRepo.getById(bookingId);
    }
    public Booking checkTrackingId(String trackingId){
        return bookingRepo.checkTrackingId(trackingId);
    }
    public Booking getBookingInformationByTrackingId(String trackingId){
        Booking booking=bookingRepo.checkTrackingId(trackingId);
            return booking;

    }
    public List<Booking> getAllBookingInfo(){
        return bookingRepo.findAll();
    }
    public List<Booking> getAllBookingInfoByUserName(String userName){
        return bookingRepo.getAllBookingInfoByUserName(userName);
    }
    public void deleteBookingById(Integer id){
        bookingRepo.deleteById(id);
    }

}
