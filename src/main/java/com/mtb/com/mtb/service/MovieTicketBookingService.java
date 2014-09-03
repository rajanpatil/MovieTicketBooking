package com.mtb.com.mtb.service;

import com.mtb.BookingRequest;
import com.mtb.BookingResponse;

/**
 * Created by ee on 3/9/14.
 */
public class MovieTicketBookingService {
    public BookingResponse bookTicket(BookingRequest request) {
        return BookingResponse.newBookingResponse().withMsg("booked").build();
    }
}
