package homework6.task3;

import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Deprecated
public @interface SomeAnno {
    String author() default "author";
    String version() default "1.1.1";
}
