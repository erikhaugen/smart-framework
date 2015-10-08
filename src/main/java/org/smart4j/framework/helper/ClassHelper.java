package org.smart4j.framework.helper;

import java.lang.annotation.Annotation;
import java.util.HashSet;
import java.util.Set;

import org.smart4j.framework.annotation.Action;
import org.smart4j.framework.annotation.Service;
import org.smart4j.framework.util.ClassUtil;

/**
 * ���������
 * <p>
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
     *
     * @return
     */
    public static Set<Class<?>> getClassSet() {
        return CLASS_SET;
    }

    /**
     * ��ȡ����Ӧ�ð��µ� Service ��
     *
     * @return
     */
    public static Set<Class<?>> getServiceClassSet() {
        Set<Class<?>> classSet = new HashSet<Class<?>>();
        for (Class<?> cls : CLASS_SET) {
            if (cls.isAnnotationPresent(Service.class)) {
                classSet.add(cls);
            }
        }
        return classSet;
    }

    /**
     * ��ȡӦ�ð������е� Controller ��
     *
     * @return
     */
    public static Set<Class<?>> getControllerClassSet() {
        Set<Class<?>> classSet = new HashSet<Class<?>>();
        for (Class<?> cls : CLASS_SET) {
            if (cls.isAnnotationPresent(Action.class)) {
                classSet.add(cls);
            }
        }
        return classSet;
    }

    /**
     * ��ȡӦ�ð������е� Bean �ࣨ������Service��Controller �ȣ�
     *
     * @return
     */
    public static Set<Class<?>> getBeanClassSet() {
        Set<Class<?>> beanCLassSet = new HashSet<Class<?>>();
        beanCLassSet.addAll(getServiceClassSet());
        beanCLassSet.addAll(getControllerClassSet());
        return beanCLassSet;
    }

    /**
     * ��ȡӦ�ð���ĳ���ࣨ��ӿڣ����������ࣨ��ʵ���ࣩ
     * @param superClass
     * @return
     */
    public static Set<Class<?>> getClassSetBySuper(Class<?> superClass) {
        Set<Class<?>> classSet = new HashSet<Class<?>>();
        for (Class<?> cls : CLASS_SET) {
            if (superClass.isAssignableFrom(cls) && !superClass.equals(cls)) {
                classSet.add(cls);
            }
        }
        return classSet;
    }

    /**
     * ��ȡӦ�ð����´���ĳע���������
     * @param annotationClass
     * @return
     */
    public static Set<Class<?>> getClassSetByAnnotation(Class<? extends Annotation> annotationClass){
        Set<Class<?>> classSet = new HashSet<Class<?>>();
        for (Class<?> cls : classSet) {
           if (cls.isAnnotationPresent(annotationClass)){
               classSet.add(cls);

           }
        }
        return classSet;
    }
}
