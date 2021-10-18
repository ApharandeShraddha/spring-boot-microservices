package rating.info.service.modules;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Arrays;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserRating {

    private String userId;
    private List<Rating> ratings;

    public void initData(String userId) {
        this.setUserId(userId);
        this.setRatings(Arrays.asList(
                new Rating("100", 3),
                new Rating("200", 4)
        ));
    }

}
