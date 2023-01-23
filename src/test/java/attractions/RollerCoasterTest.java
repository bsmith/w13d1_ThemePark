package attractions;

import org.junit.Before;
import org.junit.Test;
import people.Visitor;

import static org.junit.Assert.*;

public class RollerCoasterTest {

    RollerCoaster rollerCoaster;

    @Before
    public void setUp() {
        rollerCoaster = new RollerCoaster("Blue Ridge", 10);
    }

    @Test
    public void hasName() {
        assertEquals("Blue Ridge", rollerCoaster.getName());
    }

    @Test
    public void hasRating() {
        assertEquals(10, rollerCoaster.getRating());
    }

    @Test
    public void hasVisitCount() {
        assertEquals(0, rollerCoaster.getVisitCount());
    }

    /* RollerCoster implements ISecurity and requires a visitor to be over 145cm tall and over 12 years of age */
    @Test
    public void allowsTallAndOldVisitor() {
        Visitor visitor = new Visitor(13, 146., 10.);
        assertTrue(rollerCoaster.isAllowedTo(visitor));
    }

    @Test
    public void disallowsShortAndOldVisitor() {
        Visitor visitor = new Visitor(13, 145., 10.);
        assertFalse(rollerCoaster.isAllowedTo(visitor));
    }

    @Test
    public void disallowsTallAndYoungVisitor() {
        Visitor visitor = new Visitor(12, 146., 10.);
        assertFalse(rollerCoaster.isAllowedTo(visitor));
    }

    @Test
    public void disallowsShortAndYoungVisitor() {
        Visitor visitor = new Visitor(12, 145., 10.);
        assertFalse(rollerCoaster.isAllowedTo(visitor));
    }

    @Test
    public void defaultPriceCorrect() {
        assertEquals(8.40, rollerCoaster.defaultPrice(), 0.000);
    }

    @Test
    public void chargesNormalVisitorDefaultPrice() {
        Visitor visitor = new Visitor(20, 200., 20.);
        assertEquals(8.40, rollerCoaster.priceFor(visitor), 0.000);
    }

    @Test
    public void chargesTallVisitorDoublePrice() {
        Visitor visitor = new Visitor(20, 201., 20.);
        assertEquals(2*8.40, rollerCoaster.priceFor(visitor), 0.000);
    }
}
