package attractions;

import behaviours.ISecurity;
import org.jetbrains.annotations.NotNull;
import people.Visitor;

public class Playground extends Attraction implements ISecurity {

    public Playground(String name, int rating) {
        super(name, rating);
    }

    @Override
    public boolean isAllowedTo(@NotNull Visitor visitor) {
        /* maximum age of 15 */
        return visitor.getAge() <= 15;
    }

    @Override
    public ISecurity getSecurity() {
        return this;
    }
}
