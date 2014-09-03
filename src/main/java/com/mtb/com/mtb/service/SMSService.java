package com.mtb.com.mtb.service;

import com.mtb.BookingRequest;

/**
 * Created by ee on 3/9/14.
 */
public class SMSService {

    private MovieTicketBookingService service = new MovieTicketBookingService();

    public String send(String smsRequest) {
        return service.bookTicket(createBookingRequest(smsRequest)).toString();
    }

    private BookingRequest createBookingRequest(String smsRequest){
        return BookingRequest.newBookingRequest().withName(smsRequest.split(",")[0].split(":")[1]).withSeats(new Integer(smsRequest.split(",")[1].split(":")[1]).intValue()).withShowtime(smsRequest.split(",")[2].split(":")[1]).build();
    }

}
