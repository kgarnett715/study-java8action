package study.java8action.chapter2;

import java.util.Locale;

public class Apple {
    private String color;
    private int weight;

    public Apple(String color, int weight){
        this.color = color.toLowerCase(Locale.ROOT);
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color.toLowerCase();
    }

    public int getWeight() {return weight;}
    public void setWeight(int weight) {this.weight = weight;}

    @Override
    public String toString() {
        return "Apple{" +
                "color='" + color + '\'' +
                ", weight=" + weight +
                '}';
    }
}
