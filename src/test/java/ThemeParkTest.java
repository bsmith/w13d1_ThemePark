import attractions.*;
import behaviours.IRated;
import org.junit.Before;
import org.junit.Test;
import people.Visitor;
import stalls.CandyflossStall;
import stalls.IceCreamStall;
import stalls.ParkingSpot;
import stalls.TobaccoStall;

import java.util.*;

import static org.junit.Assert.*;

public class ThemeParkTest {
    Dodgems dodgems;
    Park park;
    Playground playground;
    RollerCoaster rollerCoaster;
    CandyflossStall candyflossStall;
    IceCreamStall iceCreamStall;
    TobaccoStall tobaccoStall;
    ThemePark themePark;

    @Before
    public void setUp() {
        dodgems = new Dodgems("Bumper Cars", 5);
        park = new Park("Leafy Meadows", 9);
        playground = new Playground("Fun Zone", 7);
        rollerCoaster = new RollerCoaster("Blue Ridge", 10);
        candyflossStall = new CandyflossStall("Candy Land", "Harry Belafonte", ParkingSpot.A1);
        iceCreamStall = new IceCreamStall("Dream Cones", "Vanilla Ice", ParkingSpot.A4);
        tobaccoStall = new TobaccoStall("Jacks Drum", "Jack Jarvis", ParkingSpot.B1);
        themePark = new ThemePark();
    }

    @Test
    public void startsEmpty() {
        assertTrue(themePark.getAllReviewed().isEmpty());
    }

    @Test
    public void canAddAllAttractions() {
        themePark.addAttraction(dodgems);
        themePark.addAttraction(park);
        themePark.addAttraction(playground);
        themePark.addAttraction(rollerCoaster);
        assertEquals(4, themePark.getAllReviewed().size());
    }

    @Test
    public void canAddAllStalls() {
        themePark.addStall(candyflossStall);
        themePark.addStall(iceCreamStall);
        themePark.addStall(tobaccoStall);
        assertEquals(3, themePark.getAllReviewed().size());
    }

    @Test
    public void canAddMixture() {
        themePark.addAttraction(park);
        themePark.addStall(iceCreamStall);
        assertEquals(2, themePark.getAllReviewed().size());
    }

    @Test
    public void canVisitAttraction() {
        themePark.addAttraction(park);
        themePark.addStall(iceCreamStall);
        Visitor visitor = new Visitor(20, 175., 50.);
        themePark.visitAttraction(visitor, park);
//        assertEquals(1, park.getVisitCount());
//        assertEquals(park, visitor.getVisitedAttractions().get(0));
        assertEquals(new ArrayList<>(Arrays.asList(park)), visitor.getVisitedAttractions());
    }

    @Test
    public void canGetAllReviews() {
        themePark.addAttraction(park);
        themePark.addStall(iceCreamStall);
        tobaccoStall.setRating(4);
        themePark.addStall(tobaccoStall);
        Map<String, Integer> reviews = themePark.getReviews();
        Map<String, Integer> expected = new HashMap<>();
//        assertEquals(2, reviews.size());
//        assertEquals((Integer)9, reviews.get("Leafy Meadows"));
//        assertEquals((Integer)4, reviews.get("Jacks Drum"));
        expected.put("Leafy Meadows", 9);
        expected.put("Jacks Drum", 4);
        assertEquals(expected, reviews);
    }

    @Test
    public void canGetAllowedFor() {
        Visitor visitor = new Visitor(12, 150., 20.);
        themePark.addAttraction(dodgems);
        themePark.addAttraction(park);
        themePark.addAttraction(playground);
        themePark.addAttraction(rollerCoaster);
        themePark.addStall(candyflossStall);
        themePark.addStall(iceCreamStall);
        themePark.addStall(tobaccoStall);
        List<IRated> allowed = themePark.getAllowedFor(visitor);
        for (IRated reviewed : allowed) {
            System.out.println(reviewed);
        }
        assertEquals(5, allowed.size());
        assertTrue(allowed.contains(dodgems));
        assertTrue(allowed.contains(park));
        assertTrue(allowed.contains(playground));
        assertTrue(allowed.contains(candyflossStall));
        assertTrue(allowed.contains(iceCreamStall));
    }
}