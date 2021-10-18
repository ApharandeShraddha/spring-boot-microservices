package movie.user.profile.service.modules;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserRating {

    private String userId;
    private List<Rating> ratings;

}
