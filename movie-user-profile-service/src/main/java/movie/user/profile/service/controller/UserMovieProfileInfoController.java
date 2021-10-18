package movie.user.profile.service.controller;

import movie.user.profile.service.MovieUserProfileService;
import movie.user.profile.service.modules.Movie;
import movie.user.profile.service.modules.UserMovieProfile;
import movie.user.profile.service.modules.UserRating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/userProfile")
public class UserMovieProfileInfoController {

    @Autowired
    MovieUserProfileService movieUserProfileService;

    @RequestMapping("/{userId}")
    public List<UserMovieProfile> getUserProfile(@PathVariable("userId") String userId) {

        UserRating userRating = movieUserProfileService.getUserRatingByUserId(userId);

        return userRating.getRatings().stream()
                .map(rating -> {
                    Movie movie = movieUserProfileService.getMovieInfo(rating.getMovieId());
                    return new UserMovieProfile(movie.getName(), "Description", rating.getRating());
                })
                .collect(Collectors.toList());
    }
}
