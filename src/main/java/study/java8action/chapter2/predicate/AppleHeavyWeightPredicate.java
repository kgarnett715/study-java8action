package study.java8action.chapter2.predicate;

import study.java8action.chapter2.Apple;

public class AppleHeavyWeightPredicate implements ApplePredicate {
    @Override
    public boolean test(Apple apple) {
        return (apple.getWeight() >= 30)? true : false;
    }
}
