package behaviours;

public class ReviewedImpl implements IReviewed {
    private int rating;
    private final String name;

    public ReviewedImpl(String name) {
        this.rating = 0;
        this.name = name;
    }

    public void setRating(int rating) {
        /* clamp ratings to [1..10] */
        this.rating = Math.max(1, Math.min(rating, 10));
    }

    @Override
    public int getRating() {
        return rating;
    }

    @Override
    public String getName() {
        return name;
    }
}
