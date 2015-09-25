package org.smart4j.framework.helper;

import java.util.HashSet;
import java.util.Set;

import org.smart4j.framework.annotation.Action;
import org.smart4j.framework.annotation.Service;
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

    /**
     * ��ȡ����Ӧ�ð��µ� Service ��
     * @return
     */
    public static Set<Class<?>> getServiceClassSet(){
        Set<Class<?>> classSet = new HashSet<Class<?>>();
        for (Class<?> cls : CLASS_SET){
            if (cls.isAnnotationPresent(Service.class)){
                classSet.add(cls);
            }
        }
        return classSet;
    }

    /**
     * ��ȡӦ�ð������е� Controller ��
     * @return
     */
    public static Set<Class<?>> getControllerClassSet(){
        Set<Class<?>> classSet = new HashSet<Class<?>>();
        for (Class<?> cls : CLASS_SET){
            if (cls.isAnnotationPresent(Action.class)){
                classSet.add(cls);
            }
        }
        return classSet;
    }

    /**
     * ��ȡӦ�ð������е� Bean �ࣨ������Service��Controller �ȣ�
     * @return
     */
    public static Set<Class<?>> getBeanClassSet(){
        Set<Class<?>> beanCLassSet = new HashSet<Class<?>>();
        beanCLassSet.addAll(getServiceClassSet());
        beanCLassSet.addAll(getControllerClassSet());
        return beanCLassSet;
    }
}
