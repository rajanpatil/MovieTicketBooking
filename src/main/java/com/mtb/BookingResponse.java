package com.mtb;

/**
 * Created by ee on 3/9/14.
 */
public class BookingResponse {
    public String msg;
    public String showTime;
    public int[] bookedSeats;

    public static BookingResponseBuilder newBookingResponse(){
        return new BookingResponseBuilder();
    }

    @Override
    public String toString() {
        StringBuilder responseMsg = new StringBuilder();
        responseMsg.append(msg);
        if(bookedSeats.length>0){
            responseMsg.append(", seats:");
            for(int seat:bookedSeats){
                responseMsg.append(seat+" ");
            }
            responseMsg.append(","+showTime);
        }
        return responseMsg.toString();
    }

    public static class BookingResponseBuilder {
        public String msg;
        public String showTime;
        public int[] bookedSeats;

        public BookingResponseBuilder withMsg(String message){
            this.msg = message;
            return this;
        }

        public BookingResponseBuilder withShowtime(String showtime){
            this.showTime = showTime;
            return this;
        }

        public BookingResponseBuilder withBookedSeats(int[] bookedSeats){
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
