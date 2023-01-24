package stalls;

import behaviours.IRated;
import behaviours.RatedImpl;

public abstract class Stall implements IRated {
    private final RatedImpl reviewedImpl;

    private final String ownerName;
    private final ParkingSpot parkingSpot;

    public Stall(String name, String ownerName, ParkingSpot parkingSpot) {
        reviewedImpl = new RatedImpl(name);
        this.ownerName = ownerName;
        this.parkingSpot = parkingSpot;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public ParkingSpot getParkingSpot() {
        return parkingSpot;
    }

    @Override
    public int getRating() {
        return reviewedImpl.getRating();
    }

    @Override
    public String getName() {
        return reviewedImpl.getName();
    }

    public void setRating(int rating) {
        reviewedImpl.setRating(rating);
    }
}
