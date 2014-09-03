package com.mtb;

import junit.framework.Assert;
import org.junit.Test;

/**
 * Created by ee on 3/9/14.
 */
public class MovieTheaterTest {

    @Test
    public void checkTheaterCapacity(){
        //given
        MovieTheater theater = new MovieTheater();

        //then
        Assert.assertEquals(50, theater.capacity);

    }

//    @Test
//    public void is11amShowAvailable(){
//        //given
//        MovieTheater theater = new MovieTheater();
//
//        //when
//        MovieShow show = theater.getShow("")
//
//        //then
//    }

}
