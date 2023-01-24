package attractions;

import behaviours.IRated;
import behaviours.RatedImpl;

public abstract class Attraction implements IRated {
    private final RatedImpl reviewedImpl;
    private int visitCount;

    public Attraction(String name, int rating) {
        reviewedImpl = new RatedImpl(name);
        reviewedImpl.setRating(rating);
        this.visitCount = 0;
    }

    public int getVisitCount() {
        return visitCount;
    }

    @Override
    public int getRating() {
        return reviewedImpl.getRating();
    }

    @Override
    public String getName() {
        return reviewedImpl.getName();
    }

    public void incrementVisitCount() {
        visitCount++;
    }
}
