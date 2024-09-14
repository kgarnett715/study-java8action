package study.java8action.chapter2.formatter;

import study.java8action.chapter2.Apple;

public class AppleWeightFormatter implements AppleFormatter {
    @Override
    public String accept(Apple apple) {
        return apple.getColor() + " apple weight: " + apple.getWeight() + "g";
    }
}
