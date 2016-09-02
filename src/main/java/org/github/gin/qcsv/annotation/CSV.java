package org.github.gin.qcsv.annotation;

import java.lang.annotation.*;

/**
 * Created by FSTMP on 2016/9/2.
 */
@Documented
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface CSV {

    String name();

    String dateFormat() default "yyyy-MM-dd HH:mm:ss";
}
