package attractions;

import org.junit.Before;
import org.junit.Test;
import people.Visitor;

import static org.junit.Assert.*;

public class PlaygroundTest {
    Playground playground;

    @Before
    public void setUp() {
        playground = new Playground("Fun Zone", 7);
    }

    @Test
    public void hasName() {
        assertEquals("Fun Zone", playground.getName());
    }

    @Test
    public void hasRating() {
        assertEquals(7, playground.getRating());
    }

    @Test
    public void hasVisitCount() {
        assertEquals(0, playground.getVisitCount());
    }

    @Test
    public void allowsUnderFifteens() {
        Visitor visitor = new Visitor(10, 100., 10.);
        assertTrue(playground.isAllowedTo(visitor));
    }

    @Test
    public void allowsFifteenYearsOld() {
        Visitor visitor = new Visitor(15, 100., 10.);
        assertTrue(playground.isAllowedTo(visitor));
    }

    @Test
    public void disallowsSixteenYearOld() {
        Visitor visitor = new Visitor(16, 100., 10.);
        assertFalse(playground.isAllowedTo(visitor));
    }
}
