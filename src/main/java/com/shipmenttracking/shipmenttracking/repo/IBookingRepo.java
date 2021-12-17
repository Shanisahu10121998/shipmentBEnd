package com.shipmenttracking.shipmenttracking.repo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.shipmenttracking.shipmenttracking.model.Booking;
import java.util.List;

@Repository
public interface IBookingRepo extends JpaRepository<Booking,Integer> {

    @Query("SELECT b FROM Booking  b where b.trackingId = ?1")
    public Booking checkTrackingId(String trackingId);
    @Query("SELECT b FROM Booking  b where b.user.email = ?1")
    public List<Booking> getAllBookingInfoByUserName(String userName);
}
