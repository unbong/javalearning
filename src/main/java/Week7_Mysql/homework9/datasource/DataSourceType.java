package Week7_Mysql.homework9.datasource;

import java.lang.annotation.*;

/**
 * 数据源注解
 *
 */

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DataSourceType {
    String name() default "";
}
