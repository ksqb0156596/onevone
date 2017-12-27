package com.mk.onevone.annotation;

import java.lang.annotation.*;

@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface Test {
    boolean isNotNull() default false;
    int maxLength() default -1;

}
