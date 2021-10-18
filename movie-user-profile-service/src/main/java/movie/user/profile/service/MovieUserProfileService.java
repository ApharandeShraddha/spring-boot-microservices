package movie.user.profile.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import movie.user.profile.service.modules.Movie;
import movie.user.profile.service.modules.Rating;
import movie.user.profile.service.modules.UserRating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieUserProfileService {

    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "userRatingFallbackMethod")
    public UserRating getUserRatingByUserId(String userId) {
        return restTemplate.getForObject("http://RATINGS-INFO-SERVICE/rating/user/" + userId, UserRating.class);
    }

    @HystrixCommand(fallbackMethod = "movieInfoFallbackMethod")
    public Movie getMovieInfo(String movieId) {
        return restTemplate.getForObject("http://MOVIE-INFO-SERVICE/movies/" + movieId, Movie.class);
    }

    private UserRating userRatingFallbackMethod(String userId) {
        List<Rating> ratingList = new ArrayList<>();
        ratingList.add(new Rating("0",0));
        return new UserRating( userId, ratingList);
    }

    private Movie movieInfoFallbackMethod(String movieId) {
        return new Movie(movieId,"Unknown","Unknown");
    }

}
