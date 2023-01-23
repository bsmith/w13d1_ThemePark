package behaviours;

import java.util.Optional;

public interface IReviewed {
    int getRating();
    String getName();

    default Optional<ISecurity> getSecurity() {
        return Optional.empty();
    }
}
