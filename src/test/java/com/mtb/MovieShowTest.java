package com.mtb;

import junit.framework.Assert;
import org.junit.Test;

/**
 * Created by ee on 3/9/14.
 */
public class MovieShowTest {

    @Test
    public void checkSeatAvailability(){
        //given
        MovieShow show = MovieShow.newMovieShow().withShowTime("8pm").withCapacity(10).build();

        //when
        boolean availability = show.checkSeatAvailability(BookingRequest.newBookingRequest().withName("rajan").withSeats(5).withShowtime("8pm").build());

        //then
        Assert.assertTrue(availability);

    }

    @Test
    public void identifyDuplicateBooking() {
        //given
        MovieShow show = MovieShow.newMovieShow().withShowTime("8pm").withCapacity(10).build();

        //when
        show.book(BookingRequest.newBookingRequest().withName("rajan").withSeats(5).withShowtime("8pm").build());
        boolean duplicateBookingCheck = show.duplicateBookingCheck(BookingRequest.newBookingRequest().withName("rajan").withSeats(5).withShowtime("8pm").build());

        //then
        Assert.assertTrue(duplicateBookingCheck);
    }

    @Test
    public void bookTicketsFor3pmShow6Seats() {
        //given
        MovieShow show = MovieShow.newMovieShow().withShowTime("3pm").withCapacity(50).build();

        //when
        BookingResponse response = show.book(BookingRequest.newBookingRequest().withName("rajan").withSeats(6).withShowtime("3pm").build());

        //then
        Assert.assertEquals("booked", response.msg);
    }
}
