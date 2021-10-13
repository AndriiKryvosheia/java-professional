package homework6.task2;

/**
 *
 */
public class MathHandler {

    /**
     *
     * @param num1
     * @param num2
     * @return num1 + num2
     */
    @MathAnnotation(operation = Operation.ADD, num1 = 10, num2 = 15)
    public static double addTwoNumbers(int num1, int num2) {
        return num1 + num2;
    }

    /**
     *
     * @param num1
     * @param num2
     * @return num1 - num2
     */
    @MathAnnotation(operation = Operation.SUB, num1 = 10, num2 = 15)
    public static double subTwoNumbers(int num1, int num2) {
        return num1 - num2;
    }

    /**
     * _mulTwoNumbers_
     * @param num1 int
     * @param num2 int
     * @return num1 * num2
     * @since Java 8
     */
    @MathAnnotation(operation = Operation.MUL, num1 = 10, num2 = 15)
    public static double mulTwoNumbers(int num1, int num2) {
        return num1 * num2;
    }

    @MathAnnotation(operation = Operation.DIV, num1 = 10, num2 = 15)
    public static double divTwoNumbers(int num1, int num2) {
        try {
            return num1 / num2;
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }
        return 0;
    }
}
