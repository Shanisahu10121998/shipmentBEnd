package com.shipmenttracking.shipmenttracking.model;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;


import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "BOOKING")
public class Booking
{

    public enum Status
    {
        BOOKED, SHIPMENT,DELIVERED
    }
    public enum Priority
    {
        LOW, MID, HIGH, URGENT
    }
    @Id
    @GeneratedValue
    @Column(name = "booking_id")
    private int bookingId;
    @CreationTimestamp
    @Column(name = "date")
    private Date date;
    @Column(name = "tracking_id")
    private String trackingId;
    @Column(name = "status_comment")
    private String statusComment;
    @Column(name = "user_instruction")
    private String userInstruction;

    @ManyToOne(cascade= CascadeType.ALL)
    @JoinColumn(name = "USer_id_fk")
    private User user;

    //sender
    @Column(name = "sender_name")
    private String senderName;
    @Column(name = "sender_mobile_number",length = 50)
    private String senderMobileNumber;
    @Column(name = "sender_email_id",unique = true)
    private String senderEmailId;
    @Column(name = "sender_country_name")
    private String senderCountryName;
    @Column(name = "sender_state_name")
    private String senderStateName;
    @Column(name = "sender_city_name")
    private String senderCityName;
    @Column(name = "sender_pin_code")
    private int senderPinCode;

    //receiver
    @Column(name = "receiver_name")
    private String receiverName;
    @Column(name = "receiver_mobile_number")
    private String receiverMobileNumber;
    @Column(name = "receiver_email_id")
    private String receiverEmailId;
    @Column(name = "receiver_country_name")
    private String receiverCountryName;
    @Column(name = "receiver_state_name")
    private String receiverStateName;
    @Column(name = "receiver_city_name")
    private String receiverCityName;
    @Column(name = "receiver_pin_code")
    private int receiverPinCode;
    @Column(name = "status")
    private String Status;

}
