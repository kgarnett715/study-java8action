package study.java8action.chapter2.predicate;

import study.java8action.chapter2.Apple;

public class AppleGreenColorPredicate implements ApplePredicate{
    @Override
    public boolean test(Apple apple) {

        return "green".equals(apple.getColor().toLowerCase())? true : false;
    }
}
