package attractions;

import behaviours.ISecurity;
import behaviours.ITicketed;
import people.Visitor;

import java.util.Optional;

public class RollerCoaster extends Attraction implements ISecurity, ITicketed {
    private static final double startingPrice = 8.40;

    public RollerCoaster(String name, int rating) {
        super(name, rating);
    }

    @Override
    public boolean isAllowedTo(Visitor visitor) {
        return visitor.getAge() > 12 && visitor.getHeight() > 145;
    }

    @Override
    public double defaultPrice() {
        return startingPrice;
    }

    @Override
    public double priceFor(Visitor visitor) {
        double price = this.defaultPrice();
        return visitor.getHeight() > 200 ? price * 2 : price;
    }

    @Override
    public Optional<ISecurity> getSecurity() {
        return Optional.of(this);
    }
}
