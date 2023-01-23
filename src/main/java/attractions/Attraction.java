package attractions;

import behaviours.IReviewed;
import behaviours.ReviewedImpl;

public abstract class Attraction implements IReviewed {
    private final ReviewedImpl reviewedImpl;
    private final int visitCount;

    public Attraction(String name, int rating) {
        reviewedImpl = new ReviewedImpl(name);
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
}
