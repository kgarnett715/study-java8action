package study.java8action.chapter2;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import study.java8action.chapter2.formatter.AppleFormatter;
import study.java8action.chapter2.formatter.AppleWeightFormatter;
import study.java8action.chapter2.formatter.LightOrHeavyFormatter;
import study.java8action.chapter2.predicate.AppleHeavyWeightPredicate;

import java.util.ArrayList;
import java.util.List;

class AppleFilterTest {

    List<Apple> apples;
    List<String> numbers = new ArrayList<>();

    @BeforeEach
    void setUp() {

        apples = new ArrayList<>();
        apples.add(new Apple("green", 10));
        apples.add(new Apple("red", 10));
        apples.add(new Apple("red", 20));
        apples.add(new Apple("green", 20));
        apples.add(new Apple("green", 30));
        apples.add(new Apple("green", 40));

        numbers.add("11");
        numbers.add("22");
        numbers.add("3");
        numbers.add("44");
        numbers.add("5");
    }

    @AfterEach
    void tearDown() {
    }

    //1단계 - 모든 조건 구현
    @Test
    void filterGreenApples() {
        AppleFilter appleFilter = new AppleFilter();
        List<Apple> result =  appleFilter.filterGreenApples(apples);

        result.forEach(apple -> System.out.println(apple.toString()));
        Assertions.assertEquals(4, result.size());

    }

    @Test
    void filterRedApples() {
        AppleFilter appleFilter = new AppleFilter();
        List<Apple> result =  appleFilter.filterRedApples(apples);

        result.forEach(apple -> System.out.println(apple.toString()));
        Assertions.assertEquals(2, result.size());
    }

    //2단계 - 동일조건 파라미터화
    @Test
    void filterApplesByColor_Green() {
        AppleFilter appleFilter = new AppleFilter();
        List<Apple> result =  appleFilter.filterApplesByColor(apples, "green");

        result.forEach(apple -> System.out.println(apple.toString()));
        Assertions.assertEquals(4, result.size());
    }

    @Test
    void filterApplesByColor_Red() {
        AppleFilter appleFilter = new AppleFilter();
        List<Apple> result =  appleFilter.filterApplesByColor(apples, "red");

        result.forEach(apple -> System.out.println(apple.toString()));
        Assertions.assertEquals(2, result.size());
    }

    @Test
    void filterApplesByWeight() {
        AppleFilter appleFilter = new AppleFilter();
        List<Apple> result =  appleFilter.filterApplesByWeight(apples, 30);

        result.forEach(apple -> System.out.println(apple.toString()));
        Assertions.assertEquals(2, result.size());
    }

    //3단계 - 동작파라미터(클래스)
    @Test
    void filterApplesByWeight_Red_predicate() {
        AppleFilter appleFilter = new AppleFilter();
        List<Apple> result =  appleFilter.filterApplesByPredicate(apples, new AppleHeavyWeightPredicate());

        result.forEach(apple -> System.out.println(apple.toString()));
        Assertions.assertEquals(2, result.size());
    }

    @Test
    void prettyPrintWeight_formatter() {
        AppleFilter appleFilter = new AppleFilter();
        appleFilter.prettyPrintApples(apples, new AppleWeightFormatter());
    }


    @Test
    void prettyPrintHeavy_formatter() {
        AppleFilter appleFilter = new AppleFilter();
        appleFilter.prettyPrintApples(apples, new LightOrHeavyFormatter());
    }

    //4단계 - 동작파라미터(익명클래스)
    @Test
    void prettyPrintHeavy_formatter_anonymous() {
        AppleFilter appleFilter = new AppleFilter();
        appleFilter.prettyPrintApples(apples, new AppleFormatter(){
            public String accept(Apple apple) {
                return apple.getWeight() > 20? "익명클래스로 구현-무겁다" : "익명클래스로 구현-가볍다";
            }
        });
    }

    //5단계 - 동작파라미터(람다)
    @Test
    void prettyPrintHeavy_formatter_lambda() {
        AppleFilter appleFilter = new AppleFilter();
        appleFilter.prettyPrintApples(apples, (Apple apple) -> apple.getWeight() > 20? "람다구현-무겁다":"람다구현:가볍다");
    }

    //6단계 - 동작파라미터(람다 + 형식파라미터<T>)
    @Test
    void filterApple_predicate_lambda_T() {
        AppleFilter appleFilter = new AppleFilter();
        List<Apple> result = appleFilter.filter(apples, (Apple apple) -> apple.getWeight() > 20? true:false);

        result.forEach(apple -> System.out.println(apple.toString()));
        Assertions.assertEquals(2, result.size());
    }

    @Test
    void filterNum_predicate_lambda_T() {
        AppleFilter appleFilter = new AppleFilter();
        List<String> result = appleFilter.filter(numbers, (String number) -> number.length() == 1);

        result.forEach(number -> System.out.println(number.toString()));
        Assertions.assertEquals(2, result.size());
    }
}