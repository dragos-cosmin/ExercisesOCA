package org.example.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target(value = {ElementType.FIELD,ElementType.CONSTRUCTOR})
public @interface CustomAnnotation {
    String owner();
    int count() default 100;
}
