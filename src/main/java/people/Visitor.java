package people;

import attractions.Attraction;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Visitor {
    private final int age;
    private final double height;
    private final double money;

    /* Visitors could revisit attractions if they really love them! */
    private final List<Attraction> visitedAttractions;

    public Visitor(int age, double height, double money) {
        this.age = age;
        this.height = height;
        this.money = money;
        this.visitedAttractions = new ArrayList<>();
    }

    public int getAge() {
        return age;
    }

    public double getHeight() {
        return height;
    }

    public double getMoney() {
        return money;
    }

    /* This is where we could be doing something with ISecurity and ITicketed?
    * But it's not really the responsibility of the Visitor? */
    public void visitAttraction(Attraction attraction) {
        visitedAttractions.add(attraction);
    }

    public List<Attraction> getVisitedAttractions() {
        return Collections.unmodifiableList(visitedAttractions);
    }
}
