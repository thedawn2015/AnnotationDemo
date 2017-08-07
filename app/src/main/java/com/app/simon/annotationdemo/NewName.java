package com.app.simon.annotationdemo;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * desc: NewName，定义注解
 * date: 2017/8/7
 *
 * @author xw
 */

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface NewName {
    String name() default "Simon";
}
