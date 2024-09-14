package study.java8action.chapter2.formatter;

import study.java8action.chapter2.Apple;

public class LightOrHeavyFormatter implements AppleFormatter {
    @Override
    public String accept(Apple apple) {
        String result = apple.getColor() + " apple is 20g보다 ";
        return result + ((apple.getWeight() > 20)? "무겁다":"가볍다");
    }
}
