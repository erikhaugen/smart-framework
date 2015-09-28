package org.smart4j.framework.helper;

import org.smart4j.framework.annotation.Inject;
import org.smart4j.framework.util.ArrayUtil;
import org.smart4j.framework.util.CollectionUtil;
import org.smart4j.framework.util.ReflectionUtil;

import java.lang.reflect.Field;
import java.util.Map;

/**
 * ����ע��������
 */
public final class IocHelper {
    static {
        //  ��ȡ���е� Bean ���� Bean ʵ��֮���ӳ���ϵ����� Bean Map��
        Map<Class<?>, Object> beanMap = BeanHelper.getBeanMap();
        if (CollectionUtil.isNotEmpty(beanMap)) {
            //���� Bean Map
            for (Map.Entry<Class<?>, Object> beanEntry : beanMap.entrySet()) {
                //�� BeanMap �л�ȡ Bean ��� Bean ��ʵ��
                Class<?> beanClass = beanEntry.getKey();
                Object beanInstance = beanEntry.getValue();
                //��ȡ Bean �ඨ������г�Ա���� ����� Bean field��
                Field[] beanFields = beanClass.getFields();
                if (ArrayUtil.isNotEmpty(beanFields)) {
                    //����Bean Field
                    for (Field beanField : beanFields) {
                        //�жϵ�ǰ Bean �Ƿ���� Inject ע��
                        if (beanField.isAnnotationPresent(Inject.class)) {
                            Class<?> beanFiledClass = beanField.getType();
                            Object beanFieldInstance = beanMap.get(beanFiledClass);
                            if (beanFieldInstance != null) {
                                //ͨ�������ʼ�� BeanField ��ֵ
                                ReflectionUtil.setField(beanInstance, beanField, beanFieldInstance);
                            }
                        }
                    }
                }
            }
        }
    }
}
