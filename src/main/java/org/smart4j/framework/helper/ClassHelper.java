package org.smart4j.framework.helper;

import java.util.HashSet;
import java.util.Set;

/**
 * ���������
 *
 * Created by Administrator on 2015/9/25.
 */
public final class ClassHelper {
    /**
     * �����༯��(���ڴ�ż��ص���)
     */
    private static final Set<Class<?>> CLASS_SET;

    static {
        String basePackage = ConfigHelper.getAppBasePackge();
        CLASS_SET = ClassUtil.getClassSet(basePackage);
    }

    /**
     * ��ȡӦ�ð������е���
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
