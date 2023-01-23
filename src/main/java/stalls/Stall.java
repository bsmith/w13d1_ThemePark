package stalls;

import behaviours.IReviewed;
import behaviours.ReviewedImpl;

public abstract class Stall implements IReviewed {
    private final ReviewedImpl reviewedImpl;

    private final String ownerName;
    private final ParkingSpot parkingSpot;

    public Stall(String name, String ownerName, ParkingSpot parkingSpot) {
        reviewedImpl = new ReviewedImpl(name);
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
