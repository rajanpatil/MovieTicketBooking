package com.mtb;

/**
 * Created by ee on 3/9/14.
 */
public class BookingRequest {
    public String name;
    public String showTime;
    public int noOfSeats;

    private BookingRequest(){

    }

    public static BookingRequestBuilder newBookingRequest(){
        return new BookingRequestBuilder();
    }

    @Override
    public String toString() {
        return "name:"+name+",noOfSeats:"+noOfSeats+",showtime:"+showTime;
    }

    public static class BookingRequestBuilder {
        public String name;
        public String showTime;
        public int noOfSeats;

        public BookingRequestBuilder withName(String name){
            this.name = name;
            return this;
        }

        public BookingRequestBuilder withShowtime(String showtime){
            this.showTime=showtime;
            return this;
        }

        public BookingRequestBuilder withSeats(int seats){
            this.noOfSeats = seats;
            return this;
        }

        public BookingRequest build(){
            BookingRequest request = new BookingRequest();
            request.name =this.name;
            request.showTime = this.showTime;
            request.noOfSeats = this.noOfSeats;
            return request;
        }
    }
}
