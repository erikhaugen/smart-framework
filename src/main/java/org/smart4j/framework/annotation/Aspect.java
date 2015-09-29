package org.smart4j.framework.annotation;

import java.lang.annotation.*;

/**
 * Created by Administrator on 2015/9/29.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Aspect {
    /**
     * ×¢½â
     *
     * @return
     */
    Class<? extends Annotation> value();
}
