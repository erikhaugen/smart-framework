package org.smart4j.framework.helper;

import java.util.HashSet;
import java.util.Set;

/**
 * 类操作助手
 *
 * Created by Administrator on 2015/9/25.
 */
public final class ClassHelper {
    /**
     * 定义类集合(用于存放加载的类)
     */
    private static final Set<Class<?>> CLASS_SET;

    static {
        String basePackage = ConfigHelper.getAppBasePackge();
        CLASS_SET = ClassUtil.getClassSet(basePackage);
    }

    /**
     * 获取应用包下所有的类
     * @return
     */
    public static Set<Class<?>> getClassSet(){
        return CLASS_SET;
    }

    public static Set<Class<?>> getServiceClassSet(){
        Set<Class<?>> classSet = new HashSet<Class<?>>();
        return null;
    }
}
