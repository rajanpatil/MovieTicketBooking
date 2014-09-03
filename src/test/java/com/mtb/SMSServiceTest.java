package com.mtb;

/**
 * Created by ee on 3/9/14.
 */

import com.mtb.com.mtb.service.SMSService;
import junit.framework.Assert;
import org.junit.Test;

public class SMSServiceTest {

    @Test
    public void sendMovieTicketBookingSMSFor11amShow4Seats(){
        //given
        String smsRequest = "Name:Rajan,NoOfSeats:4,Show:11am";
        String smsResponse=null;
        SMSService service = new SMSService();
        //when
        smsResponse = service.send(smsRequest);
        //Then
        Assert.assertNotNull(smsResponse);
    }

    @Test
    public void sendMovieTicketBookingSMSFor3pmShow2Seats(){
        //given
        String smsRequest = "Name:Rajan,NoOfSeats:2,Show:3pm";
        String smsResponse=null;
        SMSService service = new SMSService();
        //when
        smsResponse = service.send(smsRequest);
        //Then
        Assert.assertNotNull(smsResponse);
    }

    @Test
    public void sendMovieTicketBookingSMSForDuplicateBooking(){
        //given
        String smsRequest = "Name:Rajan,NoOfSeats:2,Show:3pm";
        String smsResponse=null;
        SMSService service = new SMSService();
        //when
        smsResponse = service.send(smsRequest);

        smsResponse = service.send(smsRequest);
        //Then
        Assert.assertNotNull(smsResponse);
        Assert.assertEquals("already booked", smsResponse);
    }

    @Test
    public void sendMovieTicketBookingSMSForOverBooking(){
        //given
        String smsRequest = "Name:Rajan,NoOfSeats:60,Show:3pm";
        String smsResponse=null;
        SMSService service = new SMSService();
        //when
        smsResponse = service.send(smsRequest);
        //Then
        Assert.assertNotNull(smsResponse);
        Assert.assertEquals("seats not available", smsResponse);
    }
}
