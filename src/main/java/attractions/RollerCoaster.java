package attractions;

import behaviours.ISecurity;
import behaviours.ITicketed;
import org.jetbrains.annotations.NotNull;
import people.Visitor;

public class RollerCoaster extends Attraction implements ISecurity, ITicketed {
    private static final double STARTING_PRICE = 8.40;

    public RollerCoaster(String name, int rating) {
        super(name, rating);
    }

    @Override
    public boolean isAllowedTo(@NotNull Visitor visitor) {
        return visitor.getAge() > 12 && visitor.getHeight() > 145;
    }

    @Override
    public double defaultPrice() {
        return STARTING_PRICE;
    }

    @Override
    public double priceFor(@NotNull Visitor visitor) {
        double price = this.defaultPrice();
        return visitor.getHeight() > 200 ? price * 2 : price;
    }

    @Override
    public ISecurity getSecurity() {
        return this;
    }
}
