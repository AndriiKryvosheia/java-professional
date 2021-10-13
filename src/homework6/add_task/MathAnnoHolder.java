package homework6.add_task;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface MathAnnoHolder {
    MathAnno[] value();
}
