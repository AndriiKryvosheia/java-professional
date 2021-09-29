package homework1.task3;

import java.util.Arrays;
import java.util.Comparator;

public class SortingTheOddWay {
    public static Double[] sortItOut(Double[] array) {
        Arrays.sort(array, compareTheOddWay());
        return array;
    }

    private static Comparator<Double> compareTheOddWay() {
        return (o1, o2) -> {
            double integralPart_o1 = o1 - o1 % 1;
            double integralPart_o2 = o2 - o2 % 1;
            if ((integralPart_o1 % 2 == 0) && (integralPart_o2 % 2 == 1)) {
                return 1;
            } else if ((integralPart_o1 % 2 == 1) && (integralPart_o2 % 2 == 0)) {
                return -1;
            } else if ((integralPart_o1 % 2 == 1) && (integralPart_o2 % 2 == 1)) {
                return o1.compareTo(o2);
            } else {
                return o2.compareTo(o1);
            }
        };
    }
}
