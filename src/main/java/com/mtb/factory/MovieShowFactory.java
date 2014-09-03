package com.mtb.factory;

import com.mtb.MovieShow;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ee on 3/9/14.
 */
public class MovieShowFactory {
    public static Map<String, MovieShow> createShows(int capacity) {
        Map<String,MovieShow> shows = new HashMap<String, MovieShow>();
        shows.put("11am",MovieShow.newMovieShow().withShowTime("11am").withCapacity(capacity).build());
        shows.put("3pm",MovieShow.newMovieShow().withShowTime("3pm").withCapacity(capacity).build());
        shows.put("8pm",MovieShow.newMovieShow().withShowTime("8pm").withCapacity(capacity).build());
        return shows;
    }
}
