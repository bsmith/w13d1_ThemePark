package behaviours;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RatedImplTest {
    private RatedImpl reviewedImpl;

    @Before
    public void setUp() {
        reviewedImpl = new RatedImpl("Review Stall");
    }

    @Test
    public void hasName() {
        assertEquals("Review Stall", reviewedImpl.getName());
    }

    @Test
    public void setReviewInRange() {
        reviewedImpl.setRating(3);
        assertEquals(3, reviewedImpl.getRating());
    }

    @Test
    public void setReviewTooLow() {
        reviewedImpl.setRating(-1);
        assertEquals(1, reviewedImpl.getRating());
    }

    @Test
    public void setReviewTooHigh() {
        reviewedImpl.setRating(11);
        assertEquals(10, reviewedImpl.getRating());
    }
}