package org.smart4j.framework.helper;

import org.smart4j.framework.util.ClassUtil;

/**
 * 加载相应的 Helper 类
 * Created by Administrator on 2015/9/28.
 */
public final class HelperLoader {

    public static void init() {
        Class<?>[] classList = {
                ClassHelper.class,
                BeanHelper.class,
                IocHelper.class,
                ControllerHelper.class
        };
        for (Class<?> cls : classList) {
            ClassUtil.loadClass(cls.getName());
        }
    }
}
