package com.shipmenttracking.shipmenttracking.controller;

import com.shipmenttracking.shipmenttracking.model.Booking;

import com.shipmenttracking.shipmenttracking.wrapper.BookingWrapper;

import org.springframework.web.bind.annotation.*;


import java.util.List;

@RequestMapping("/booking")
public interface IBookingController
{
    @PostMapping(value = "create",consumes = "application/json")
    public BookingWrapper createBooking(@RequestBody BookingWrapper bookingWrapper);
    @PutMapping(value = "editShipment",consumes = "application/json")
    public Booking editShipment(@RequestBody Booking booking );
    @GetMapping(value = "/getTracking")

    public Booking getBookingInformationByTrackingId(String trackingId);
    @GetMapping(value = "/getAllBookingInfo")
    public List<BookingWrapper> getAllBookingInfo();
    @DeleteMapping("/delete")
    public void deleteBookingById(Integer bookingId);

    /*@Autowired
    public IBookingRepo bookingRepo = null;
    @RequestMapping(value = "/data/users", method = RequestMethod.GET)
    public DataTablesOutput<Booking> getUsers(@Valid DataTablesInput input);
*/
}
