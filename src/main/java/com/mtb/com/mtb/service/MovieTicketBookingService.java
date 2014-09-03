package com.mtb.com.mtb.service;

import com.mtb.BookingRequest;
import com.mtb.BookingResponse;
import com.mtb.MovieTheater;

/**
 * Created by ee on 3/9/14.
 */
public class MovieTicketBookingService {

   private MovieTheater theater = new MovieTheater();

   public BookingResponse bookTicket(BookingRequest request) {
        return theater.bookShow(request);
    }
}
