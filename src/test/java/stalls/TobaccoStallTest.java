package stalls;

import org.junit.Before;
import org.junit.Test;
import people.Visitor;

import static org.junit.Assert.*;

public class TobaccoStallTest {

    TobaccoStall tobaccoStall;

    @Before
    public void setUp() {
        tobaccoStall = new TobaccoStall("Jacks Drum", "Jack Jarvis", ParkingSpot.B1);
    }

    @Test
    public void hasName() {
        assertEquals("Jacks Drum", tobaccoStall.getName());
    }

    @Test
    public void hasOwner() {
        assertEquals("Jack Jarvis", tobaccoStall.getOwnerName());
    }

    @Test
    public void hasParkingSpot() {
        assertEquals(ParkingSpot.B1, tobaccoStall.getParkingSpot());
    }

    @Test
    public void disallowSeventeenYearOld() {
        Visitor visitor = new Visitor(17, 100., 10.);
        assertFalse(tobaccoStall.isAllowedTo(visitor));
    }

    @Test
    public void allowEighteenYearOld() {
        Visitor visitor = new Visitor(18, 100., 10.);
        assertTrue(tobaccoStall.isAllowedTo(visitor));
    }
}
