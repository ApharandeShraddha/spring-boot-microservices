package rating.info.service.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rating.info.service.modules.Rating;
import rating.info.service.modules.UserRating;

@RestController
@RequestMapping(("/rating"))
public class RatingInfoController {

    @RequestMapping("/{movieId}")
    public Rating getRatingInfo(@PathVariable("movieId") String movieId) {
        return new Rating(movieId, 4);
    }

    @RequestMapping("/user/{userId}")
    public UserRating getUserRatings(@PathVariable("userId") String userId) {
        UserRating userRating = new UserRating();
        userRating.initData(userId);
        return userRating;

    }
}
