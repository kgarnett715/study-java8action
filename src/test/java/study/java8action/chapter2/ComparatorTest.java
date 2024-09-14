package study.java8action.chapter2;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import study.java8action.chapter2.comparator.AppleWeightComparator;

import java.util.ArrayList;
import java.util.List;

public class ComparatorTest {

    List<Apple> apples;
    List<String> numbers = new ArrayList<>();

    @BeforeEach
    void setUp() {

        apples = new ArrayList<>();
        apples.add(new Apple("green", 10));
        apples.add(new Apple("red", 10));
        apples.add(new Apple("green", 40));
        apples.add(new Apple("green", 20));
        apples.add(new Apple("blue", 22));
        apples.add(new Apple("green", 30));
        apples.add(new Apple("red", 20));
        apples.add(new Apple("green", 17));

        numbers.add("11");
        numbers.add("22");
        numbers.add("3");
        numbers.add("44");
        numbers.add("5");
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void sortApplesWeightUsingCollections(){
        List<Apple> sortedApples = AppleWeightComparator.sortApplesUsingCollections(apples);
        System.out.println(sortedApples);
    }
    @Test
    void sortApplesWeightUsingList(){
        List<Apple> sortedApples = AppleWeightComparator.sortApplesUsingCollections(apples);
        System.out.println(sortedApples);
    }
    @Test
    void sortApplesUsingLambda(){
        List<Apple> sortedApples = AppleWeightComparator.sortApplesUsingCollections(apples);
        System.out.println(sortedApples);
    }
}
