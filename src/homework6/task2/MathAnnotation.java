package homework6.task2;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface MathAnnotation {
    Operation operation();
    int num1() default 0;
    int num2() default 0;
}
