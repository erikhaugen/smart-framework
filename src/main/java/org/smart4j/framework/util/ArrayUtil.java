package org.smart4j.framework.util;

import org.apache.commons.lang3.ArrayUtils;

/**
 * ���鹤����
 * Created by Administrator on 2015/9/28.
 */
public final class ArrayUtil {
    /**
     * �ж������Ƿ�ǿ�
     *
     * @param array
     * @return
     */
    public static boolean isNotEmpty(Object[] array) {
        return !ArrayUtils.isEmpty(array);
    }

    /**
     * �ж������Ƿ�Ϊ��
     *
     * @param array
     * @return
     */
    public static boolean isEmpty(Object[] array) {
        return ArrayUtils.isEmpty(array);
    }
}
