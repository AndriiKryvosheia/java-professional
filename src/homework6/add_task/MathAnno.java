package homework6.add_task;

import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@Repeatable(MathAnnoHolder.class)
public @interface MathAnno {
    int num();
}
