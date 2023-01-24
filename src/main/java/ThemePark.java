import attractions.Attraction;
import behaviours.IReviewed;
import people.Visitor;
import stalls.Stall;

import java.util.*;

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

    public Map<String, Integer> getReviews() {
        Map<String, Integer> reviews = new HashMap<>();
        for (IReviewed reviewed : this.getAllReviewed()) {
            int rating = reviewed.getRating();
            if (rating != 0)
                reviews.put(reviewed.getName(), rating);
        }
        return reviews;
    }

    /* Alternative design?  Visitor pattern... */
    /* Add visit(ThemeParkVisitor) to IReviewed.  Then each IReviewed calls ThemeParkVisitor.visitWithoutSecurity(IReviewed) or ThemeParkVisitor.visitWithSecurity(ISecurity, IReviewed) */
    /* The solution below is very similar in some ways, and simpler! */
    public List<IReviewed> getAllowedFor(Visitor visitor) {
        List<IReviewed> allowed = new ArrayList<>();
        for (IReviewed reviewed : this.getAllReviewed()) {
//            if (reviewed instanceof ISecurity)
//            Optional<ISecurity securityOptional;
//            if ((securityOptional = reviewed.getSecurity()).isPresent())
//                if (!securityOptional.get().isAllowedTo(visitor))
//                    continue;
            if (!reviewed.getSecurity().isAllowedTo(visitor))
                continue;
            allowed.add(reviewed);
        }
        return allowed;
    }
}
