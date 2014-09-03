package com.mtb;

import com.mtb.com.mtb.service.MovieTicketBookingService;
import junit.framework.Assert;
import org.junit.Test;

/**
 * Created by ee on 3/9/14.
 */
public class MovieTicketBookingServiceTest {

    @Test
    public void bookTicketFor11amShow4Seats(){
        //given
        MovieTicketBookingService service = new MovieTicketBookingService();
        BookingRequest request = BookingRequest.newBookingRequest().withName("rajan").withSeats(4).withShowtime("11am").build();
        BookingResponse response;

        //when
        response =service.bookTicket(request);

        //then

        Assert.assertEquals("booked", response.msg);
    }

    @Test
    public void bookTicketFor3pmShow2Seats(){
        //given
        MovieTicketBookingService service = new MovieTicketBookingService();
        BookingRequest request = BookingRequest.newBookingRequest().withName("rajan").withSeats(2).withShowtime("3pm").build();
        BookingResponse response;

        //when
        response =service.bookTicket(request);

        //then

        Assert.assertEquals("booked", response.msg);
    }
}
