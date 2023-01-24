import attractions.Attraction;
import behaviours.IRated;
import org.jetbrains.annotations.NotNull;
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

    public List<IRated> getAllReviewed() {
        ArrayList<IRated> reviewedThings = new ArrayList<>();
        reviewedThings.addAll(attractions);
        reviewedThings.addAll(stalls);
        return reviewedThings;
    }

    public void visitAttraction(@NotNull Visitor visitor, Attraction attraction) {
        visitor.visitAttraction(attraction);
        attraction.incrementVisitCount();
    }

    public Map<String, Integer> getReviews() {
        Map<String, Integer> reviews = new HashMap<>();
        for (IRated reviewed : this.getAllReviewed()) {
            int rating = reviewed.getRating();
            if (rating != 0)
                reviews.put(reviewed.getName(), rating);
        }
        return reviews;
    }

    /* Alternative design?  Visitor pattern... (The name is confusing in this program! Too many visitors!) */
    /* Add visit(ThemeParkVisitor) to IReviewed.  Then each IReviewed calls ThemeParkVisitor.visitWithoutSecurity(IReviewed) or ThemeParkVisitor.visitWithSecurity(ISecurity, IReviewed) */
    /* The solution below is very similar in some ways, and simpler! */
    /* The simplest thing would be to introduce IVisitable implementing IReviewed and ISecurity, with a default ISecurity implementation */
    public List<IRated> getAllowedFor(Visitor visitor) {
        List<IRated> allowed = new ArrayList<>();
        for (IRated reviewed : this.getAllReviewed()) {
//            if (reviewed instanceof ISecurity)
//                if (!(((ISecurity)reviewed).isAllowed(visitor))
//            Optional<ISecurity securityOptional;
//            if ((securityOptional = reviewed.getSecurity()).isPresent())
//                if (!securityOptional.get().isAllowedTo(visitor))
//                    continue;
            System.out.println("Security: " + reviewed.getSecurity());
            if (!reviewed.getSecurity().isAllowedTo(visitor))
                continue;
            allowed.add(reviewed);
        }
        return allowed;
    }
}
