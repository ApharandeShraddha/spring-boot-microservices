package movie.user.profile.service.modules;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserMovieProfile {
    private String movieName;
    private String movieDesc;
    private int movieRating;
}
