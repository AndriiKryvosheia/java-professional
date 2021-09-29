package homework1;

import homework1.task1.Animal;
import homework1.task3.SortingTheOddWay;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        Main main = new Main();
        main.startTask1();
        main.startTask3();
    }

    void startTask1() {
        System.out.println("\n\n/*----------TASK 1---------*/");

        Animal bird = new Animal("King Penguin", 15, 8, 50000);
        Animal swallow = new Animal("Some Bird", 15, 8, 10000);
        Animal cat = new Animal("Oriental", 7, 25, 5000);
        Animal dog1 = new Animal("1Labrador", 30, 17, 4000);
        Animal dog3 = new Animal("3Labrador", 30, 17, 4000);
        Animal dog2 = new Animal("2Labrador", 30, 17, 4000);

        Animal[] c = {cat, dog1, bird, swallow, dog3, dog2};
        Arrays.sort(c);   // ClassCastException w/o Comparable
        System.out.println(Arrays.toString(c));
    }

    void startTask3() {
        System.out.println("\n\n/*----------TASK 2---------*/");

        System.out.println(Arrays.toString(SortingTheOddWay.sortItOut(
                new Double[]{11d, 22d, 33d, 44d, 55d, 55d, 90.4, 4d, 78d})));
        System.out.println(Arrays.toString(SortingTheOddWay.sortItOut(
                new Double[]{26d, 243d, 52d, 2d, 432414d, 1d, 11d, 46d, 32d})));
        System.out.println(Arrays.toString(SortingTheOddWay.sortItOut(
                new Double[]{19d,65d,88d,112d,60d,14d,33d,49d,88d})));
    }
}
