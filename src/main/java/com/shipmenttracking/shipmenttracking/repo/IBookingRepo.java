package com.shipmenttracking.shipmenttracking.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.shipmenttracking.shipmenttracking.model.Booking;

@Repository
public interface IBookingRepo extends JpaRepository<Booking,Integer> {
    @Query("SELECT b FROM Booking  b where b.trackingId = ?1")
    public Booking checkTrackingId(String trackingId);
}
