package behaviours;

import people.Visitor;

public interface IReviewed {
    int getRating();
    String getName();

//    default Optional<ISecurity> getSecurity() {
//        return Optional.empty();
//    }

    /* can't be private static final because this is an interface! */
//    static final ISecurity noSecurity = new ISecurity() {
//        @Override
//        public boolean isAllowedTo(Visitor visitor) {
//            return true;
//        }
//    };
//    static final ISecurity noSecurity = visitor -> true;

    default ISecurity getSecurity() {
        return visitor -> true;
    }
}
