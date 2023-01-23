package attractions;

import org.junit.Before;
import org.junit.Test;
import people.Visitor;

import static org.junit.Assert.assertEquals;

public class DodgemTest {

    Dodgems dodgems;

    @Before
    public void setUp() {
        dodgems = new Dodgems("Bumper Cars", 5);
    }


    @Test
    public void hasName() {
        assertEquals("Bumper Cars", dodgems.getName());
    }

    @Test
    public void hasRating() {
        assertEquals(5, dodgems.getRating());
    }

    @Test
    public void hasVisitCount() {
        assertEquals(0, dodgems.getVisitCount());
    }


    @Test
    public void defaultPriceCorrect() {
        assertEquals(4.50, dodgems.defaultPrice(), 0.000);
    }

    @Test
    public void chargesNormalVisitorDefaultPrice() {
        Visitor visitor = new Visitor(20, 150., 20.);
        assertEquals(4.50, dodgems.priceFor(visitor), 0.000);
    }

    @Test
    public void chargesChildVisitorHalfPrice() {
        Visitor visitor = new Visitor(11, 100., 20.);
        assertEquals(0.5*4.50, dodgems.priceFor(visitor), 0.000);
    }
}
