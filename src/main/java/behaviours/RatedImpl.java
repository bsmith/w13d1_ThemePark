package behaviours;

/* This isn't really meant to be used on its own as an IReviewed! */
/* If we were using COM, we could just return this delegate directly from QueryInterface */
public class RatedImpl implements IRated {
    private int rating;
    private final String name;

    public RatedImpl(String name) {
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
