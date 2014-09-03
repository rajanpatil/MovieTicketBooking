package com.mtb;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by ee on 3/9/14.
 */
public class MovieShow {

    public String showTime;
    public boolean[] seats;
    public Set<String> currentBooking = new HashSet<String>();

    private MovieShow(){

    }

    public static MovieShowBuilder newMovieShow(){
        return new MovieShowBuilder();
    }

    public boolean checkSeatAvailability(BookingRequest request) {
        if(seats.length>request.noOfSeats){
            for(int i=0;i<seats.length;i++){
                if(!seats[i]){
                    return ((seats.length-i)>=request.noOfSeats)?true:false;
                }
            }
        }
        return false;
    }

    public BookingResponse book(BookingRequest request) {
        BookingResponse.BookingResponseBuilder response = BookingResponse.newBookingResponse().withMsg("booked");
        List<Integer> bookedSeats = new ArrayList<Integer>();
        int ticketCounter = request.noOfSeats;
        if(seats.length>request.noOfSeats){
            for(int i=0;i<seats.length;i++){
                if(!seats[i]){
                    bookedSeats.add(new Integer(i+1));
                    seats[i]=true;
                    if(--ticketCounter<=0){
                        break;
                    }

                }
            }
            currentBooking.add(request.toString());
            return BookingResponse.newBookingResponse().withMsg("booked").withBookedSeats(bookedSeats).withShowtime(request.showTime).build();
        }

        return BookingResponse.newBookingResponse().withMsg("couldn't book ticket").build();
    }

    public boolean duplicateBookingCheck(BookingRequest request) {
        return currentBooking.contains(request.toString());
    }

    public static class MovieShowBuilder {
        public String time;
        public boolean[] seats;

        public MovieShowBuilder withShowTime(String showTime){
            this.time = showTime;
            return this;
        }

        public MovieShow build(){
            MovieShow show = new MovieShow();
            show.showTime = this.time;
            show.seats = new boolean[MovieTheater.capacity];
            return show;
        }
    }
}