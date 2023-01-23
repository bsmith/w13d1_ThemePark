package behaviours;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ReviewedImplTest {
    private ReviewedImpl reviewedImpl;

    @Before
    public void setUp() {
        reviewedImpl = new ReviewedImpl("Review Stall");
    }

    @Test
    public void hasName() {
        assertEquals("Review Stall", reviewedImpl.getName());
    }

    @Test
    public void setReviewInRange() {
        reviewedImpl.setReview(3);
        assertEquals(3, reviewedImpl.getRating());
    }

    @Test
    public void setReviewTooLow() {
        reviewedImpl.setReview(-1);
        assertEquals(1, reviewedImpl.getRating());
    }

    @Test
    public void setReviewTooHigh() {
        reviewedImpl.setReview(6);
        assertEquals(5, reviewedImpl.getRating());
    }
}