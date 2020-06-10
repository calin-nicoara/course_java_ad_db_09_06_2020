package ro.esolacad.javaad.reflection;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@interface ShouldUpperCase {
    boolean value() default false;
}
