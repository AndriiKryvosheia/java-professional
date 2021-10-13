package homework6;

import homework6.add_task.MathAnno;
import homework6.add_task.MathAnnoHolder;
import homework6.task2.MathAnnotation;
import homework6.task2.MathHandler;
import homework6.task2.Operation;
import homework6.task3.ClassC;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class Main {

    public static void main(String[] args) {

        Main main = new Main();
        main.startTask2();
        main.startTask3();
        main.add_Task();
    }

    void startTask2() {
        System.out.println("\n\n/*----------TASK 2---------*/");

        Class<?> cl = MathHandler.class;
        try {
            Method[] methods = cl.getDeclaredMethods();
            // проверка правильности выполнения методов
            for (Method method: methods) {
                if (method.isAnnotationPresent(MathAnnotation.class)) {
                    MathAnnotation annotation = method.getAnnotation(MathAnnotation.class);
                    Operation operation = annotation.operation();
                    int num1 = annotation.num1();
                    int num2 = annotation.num2();

                    Parameter[] parameters = method.getParameters();
                    if ((parameters.length != 2) || (parameters[0].getType() != int.class)
                            || (parameters[1].getType() != int.class)
                            || (method.getReturnType() != double.class)) {
                        continue;
                    }

                    Double res = (Double) method.invoke(null, num1, num2);
                    if (operation == Operation.ADD) {
                        System.out.println("Operation.ADD => " + (res == num1 + num2));
                    } else if (operation == Operation.SUB) {
                        System.out.println("Operation.SUB => " + (res == num1 - num2));
                    } else if (operation == Operation.MUL) {
                        System.out.println("Operation.MUL => " + (res == num1 * num2));
                    } else if (operation == Operation.DIV) {
                        System.out.println("Operation.DIV => " + (res == ((num2 == 0) ? 0 : num1 / num2)));
                    } else {
                        System.out.println(false);
                    }
                }
            }
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    void startTask3() {
        System.out.println("\n\n/*----------TASK 3---------*/");

        Annotation[] declaredAnnotations = ClassC.class.getDeclaredAnnotations();
        System.out.println("DeclaredAnnotations:");
        for (Annotation an: declaredAnnotations) {
            System.out.println(an);
        }

        System.out.println();
        Annotation[] annotations = ClassC.class.getAnnotations();
        System.out.println("Annotations:");
        for (Annotation an: annotations) {
            System.out.println(an);
        }
    }

    void add_Task() {
        System.out.println("\n\n/*----------ADD_TASK---------*/");

        Class<?> cl = this.getClass();
        Method m = null;
        try {
            int sum = 0;
            m = cl.getDeclaredMethod("mathSum", int.class, int.class);
            if (m.isAnnotationPresent(MathAnnoHolder.class)) {
                MathAnnoHolder mathAnnoHolder = m.getAnnotation(MathAnnoHolder.class);
                MathAnno[] mathAnnos = mathAnnoHolder.value();
                for (MathAnno mathAnno : mathAnnos) {
                    sum += mathAnno.num();
                }
            }
            System.out.println(sum);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    @MathAnno(num = 10)
    @MathAnno(num = 20)
    public void mathSum(int num1, int num2) {
        System.out.println(num1 + num2);
    }
}
