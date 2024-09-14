package study.java8action.chapter2.comparator;

import study.java8action.chapter2.Apple;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AppleWeightComparator {

    //1-1. Comparetor 익명클래스로 동작 주입(Collections.sort() 사용)
    public static List<Apple> sortApplesUsingCollections(List<Apple> apples){
        Collections.sort(apples, new Comparator<Apple>() {
            @Override
            public int compare(Apple o1, Apple o2) {
                return o1.getWeight() > o2.getWeight() ? 0 : -1;
            }
        });
        return apples;
    }

    //1-2. Comparetor 익명클래스로 동작 주입(List.sort() 사용)
    public static List<Apple> sortApplesUsingList(List<Apple> apples){
        apples.sort(new Comparator<Apple>() {
            @Override
            public int compare(Apple o1, Apple o2) {
                return o1.getWeight() > o2.getWeight() ? 0 : -1;
            }
        });
        return apples;
    }

    //2. Comparetor 람다로 동작 주입(List.sort() 사용)
    public static List<Apple> sortApplesUsingLambda(List<Apple> apples){
        apples.sort((Apple o1, Apple o2) -> o1.getWeight() > o2.getWeight() ? 0 : -1);
        return apples;
    }
}
