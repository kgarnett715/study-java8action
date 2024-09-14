package study.java8action.chapter2;

import study.java8action.chapter2.formatter.AppleFormatter;
import study.java8action.chapter2.predicate.ApplePredicate;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class AppleFilter {

    //1단계 - 모든 조건을 구현
    public static List<Apple> filterGreenApples(List<Apple> apples) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : apples) {
            if ("green".equals(apple.getColor())) {
                result.add(apple);
            }
        }
        return result;
    }

    public static List<Apple> filterRedApples(List<Apple> apples) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : apples) {
            if ("red".equals(apple.getColor())) {
                result.add(apple);
            }
        }
        return result;
    }


    //2단계 - 조건의 일부 파라미터화 (아직도 조건마다 추가 메서드 구현 필요
    public static List<Apple> filterApplesByColor(List<Apple> apples, String color) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : apples) {
            if (color.equals(apple.getColor())) {
                result.add(apple);
            }
        }
        return result;
    }

    public static List<Apple> filterApplesByWeight(List<Apple> apples, int weight) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : apples) {
            if (apple.getWeight() >= weight) {
                result.add(apple);
            }
        }
        return result;
    }


    //3단계 - 조건의 동작파라미터화(리턴값 기준 interface 구현)
    public static List<Apple> filterApplesByPredicate(List<Apple> apples, ApplePredicate applePredicate) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : apples) {
            if (applePredicate.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }

    public static void prettyPrintApples(List<Apple> apples, AppleFormatter appleFormatter) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : apples) {
            System.out.println(appleFormatter.accept(apple));
        }
    }

    //6단계 - 형식파라미터<T> 활용하여 객체 무관 filter
    public static <T> List<T> filter(List<T> list, Predicate<T> p) {
        List<T> result = new ArrayList<T>();
        for (T e : list) {
            if (p.test(e)) {
                result.add(e);
            }
        }
        return result;
    }


}
