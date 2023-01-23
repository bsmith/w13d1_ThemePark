package attractions;

import behaviours.ISecurity;
import people.Visitor;

import java.util.Optional;

public class Playground extends Attraction implements ISecurity {

    public Playground(String name, int rating) {
        super(name, rating);
    }

    @Override
    public boolean isAllowedTo(Visitor visitor) {
        /* maximum age of 15 */
        return visitor.getAge() <= 15;
    }

    @Override
    public Optional<ISecurity> getSecurity() {
        return Optional.of(this);
    }
}
