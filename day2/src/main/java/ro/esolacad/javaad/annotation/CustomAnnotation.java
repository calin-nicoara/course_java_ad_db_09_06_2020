package ro.esolacad.javaad.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.TYPE})
@interface  CustomAnnotation {
    String name();
    String createdAt();
    Class<String> stringClass();
    int numberOfDaysInMonth() default 1;
}
