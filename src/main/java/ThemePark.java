import attractions.Attraction;
import behaviours.IReviewed;
import people.Visitor;
import stalls.Stall;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ThemePark {
    private final Set<Attraction> attractions;
    private final Set<Stall> stalls;

    public ThemePark() {
        this.attractions = new HashSet<>();
        this.stalls = new HashSet<>();
    }

    public void addAttraction(Attraction attraction) {
        attractions.add(attraction);
    }

    public void addStall(Stall stall) {
        stalls.add(stall);
    }

    public List<IReviewed> getAllReviewed() {
        ArrayList<IReviewed> reviewedThings = new ArrayList<>();
        reviewedThings.addAll(attractions);
        reviewedThings.addAll(stalls);
        return reviewedThings;
    }

    public void visitAttraction(Visitor visitor, Attraction attraction) {
        visitor.visitAttraction(attraction);
        attraction.incrementVisitCount();
    }
}
