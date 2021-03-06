package com.github.gin.qcsv.annotation;

import java.lang.annotation.*;

/**
 * Created by GinPonson on 2016/9/2.
 */
@Documented
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface CSV {

    String name();

    String dateFormat() default "yyyy-MM-dd HH:mm:ss";
}
