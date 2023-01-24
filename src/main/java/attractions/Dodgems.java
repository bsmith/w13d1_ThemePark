package attractions;

import behaviours.ITicketed;
import org.jetbrains.annotations.NotNull;
import people.Visitor;

public class Dodgems extends Attraction implements ITicketed {
    private static final double DEFAULT_PRICE = 4.50;

    public Dodgems(String name, int rating) {
        super(name, rating);
    }

    @Override
    public double defaultPrice() {
        return DEFAULT_PRICE;
    }

    @Override
    public double priceFor(@NotNull Visitor visitor) {
        return defaultPrice() * (visitor.getAge() < 12 ? .5 : 1.);
    }
}
