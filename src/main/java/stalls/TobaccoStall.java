package stalls;

import behaviours.ISecurity;
import people.Visitor;

public class TobaccoStall extends Stall implements ISecurity {

    public TobaccoStall(String name, String ownerName, ParkingSpot parkingSpot) {
        super(name, ownerName, parkingSpot);
    }

    @Override
    public boolean isAllowedTo(Visitor visitor) {
        /* Age restriction: 18 and above */
        return visitor.getAge() >= 18;
    }

    @Override
    public ISecurity getSecurity() {
        return this;
    }
}
