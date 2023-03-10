package stalls;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CandyflossStallTest {

    CandyflossStall candyflossStall;

    @Before
    public void setUp() {
        candyflossStall = new CandyflossStall("Candy Land", "Harry Belafonte", ParkingSpot.A1);
    }

    @Test
    public void hasName() {
        assertEquals("Candy Land", candyflossStall.getName());
    }

    @Test
    public void hasOwner() {
        assertEquals("Harry Belafonte", candyflossStall.getOwnerName());
    }

    @Test
    public void hasParkingSpot(){
        assertEquals(ParkingSpot.A1, candyflossStall.getParkingSpot());
    }

    @Test
    public void hasRating() {
        assertEquals(0, candyflossStall.getRating());
    }

    @Test
    public void canSetRating() {
        candyflossStall.setRating(3);
        assertEquals(3, candyflossStall.getRating());
    }
}
