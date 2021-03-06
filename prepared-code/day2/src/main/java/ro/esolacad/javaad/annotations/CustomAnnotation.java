package ro.esolacad.javaad.annotations;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@interface CustomAnnotation {
    String name();

    String createdAt();

    Class<String> stringClass();

    int numberOfDaysInAMonth() default 1;
}
