package com.mtb;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ee on 3/9/14.
 */
public class BookingResponse {
    public String msg;
    public String showTime;
    public List<Integer> bookedSeats;

    private BookingResponse(){

    }

    public static BookingResponseBuilder newBookingResponse(){
        return new BookingResponseBuilder();
    }

    @Override
    public String toString() {
        StringBuilder responseMsg = new StringBuilder();
        responseMsg.append(msg);
        if(bookedSeats.size()>0){
            responseMsg.append(", seats:");
            for(int seat:bookedSeats){
                responseMsg.append(seat+" ");
            }
            responseMsg.append(",show:"+showTime);
        }
        return responseMsg.toString();
    }

    public static class BookingResponseBuilder {
        public String msg;
        public String showTime;
        public List<Integer> bookedSeats = new ArrayList<Integer>();

        public BookingResponseBuilder withMsg(String message){
            this.msg = message;
            return this;
        }

        public BookingResponseBuilder withShowtime(String showtime){
            this.showTime =showtime;
            return this;
        }

        public BookingResponseBuilder withBookedSeats(List<Integer> bookedSeats){
            this.bookedSeats = bookedSeats;
            return this;
        }

        public BookingResponse build(){
            BookingResponse response = new BookingResponse();
            response.msg = this.msg;
            response.showTime=this.showTime;
            response.bookedSeats =this.bookedSeats;
            return response;
        }
    }
}
