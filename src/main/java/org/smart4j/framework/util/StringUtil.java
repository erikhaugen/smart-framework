package org.smart4j.framework.util;


import org.apache.commons.lang3.StringUtils;

/**
 * Created by Administrator on 2015/9/23.
 */
public final class StringUtil {
    /**
     * 判断字符串是否为空
     *
     * @param str
     * @return
     */
    public static boolean isEmpty(String str) {
        if (str != null) {
            str = str.trim();
        }
        return StringUtils.isEmpty(str);
    }

    /**
     * 判断字符串是否非空
     *
     * @param str
     * @return
     */
    public static boolean isNotEmpty(String str) {
        return !isEmpty(str);
    }

    /**
     * 按给定字符切割字符串
     *
     * @param str
     * @param regex
     * @return
     */
    public static String[] splitString(String str, String regex) {
        return str.split(regex);
    }
}
