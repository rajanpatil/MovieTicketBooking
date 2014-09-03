package com.mtb;

import com.mtb.factory.MovieShowFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ee on 3/9/14.
 */
public class MovieTheater {

    public static final int capacity =50;
    private Map<String, MovieShow> shows = MovieShowFactory.createShows();

    public BookingResponse bookShow(BookingRequest request) {
        MovieShow show= getShow(request.showTime);

        return (show.duplicateBookingCheck(request))?BookingResponse.newBookingResponse().withMsg("already booked").build():(show.checkSeatAvailability(request)?show.book(request):BookingResponse.newBookingResponse().withMsg("seats not available").build());
    }

    private MovieShow getShow(String show){
        return shows.get(show);
    }
}
