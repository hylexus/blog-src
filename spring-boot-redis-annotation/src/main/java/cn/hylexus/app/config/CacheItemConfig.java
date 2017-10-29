package cn.hylexus.app.config;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface CacheItemConfig {

    boolean valid() default true;

}
