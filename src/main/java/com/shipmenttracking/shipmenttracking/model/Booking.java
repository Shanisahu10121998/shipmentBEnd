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
    @Column(name = "status_comment",nullable = true)
    private String statusComment;
    @Column(name = "user_instruction",nullable = true)
    private String userInstruction;

    @ManyToOne(cascade= CascadeType.ALL)
    @JoinColumn(name = "USer_id_fk")
    private User user;

    //sender
    @Column(name = "sender_name",nullable = false)
    private String senderName;
    @Column(name = "sender_mobile_number",length = 15)
    private String senderMobileNumber;
    @Column(name = "sender_email_id",nullable = false)
    private String senderEmailId;
    @Column(name = "sender_city_name",nullable = false)
    private String senderCityName;
    @Column(name = "sender_pin_code",nullable = false)
    private int senderPinCode;

    //receiver
    @Column(name = "receiver_name",nullable = false)
    private String receiverName;
    @Column(name = "receiver_mobile_number",nullable = false,length = 15)
    private String receiverMobileNumber;
    @Column(name = "receiver_email_id",nullable = false)
    private String receiverEmailId;
    @Column(name = "receiver_city_name",nullable = false)
    private String receiverCityName;
    @Column(name = "receiver_pin_code",nullable = false)
    private int receiverPinCode;
    @Column(name = "status",nullable = true)
    private String Status;
    private String Priority;

}
