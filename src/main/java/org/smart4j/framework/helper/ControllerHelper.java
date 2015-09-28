package org.smart4j.framework.helper;

import org.smart4j.framework.annotation.Action;
import org.smart4j.framework.bean.Handler;
import org.smart4j.framework.bean.Request;
import org.smart4j.framework.util.ArrayUtil;
import org.smart4j.framework.util.CollectionUtil;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by Administrator on 2015/9/28.
 */
public final class ControllerHelper {

    private static final Map<Request, Handler> ACTION_MAP = new HashMap<Request, Handler>();

    static {
        //获取所有的 Controller 类
        Set<Class<?>> controllerClassSet = ClassHelper.getControllerClassSet();
        if (CollectionUtil.isNotEmpty(controllerClassSet)) {
            //遍历这些 Controller 类
            for (Class<?> controllerClass : controllerClassSet) {
                //获取 Controller 类中的定义方法
                Method[] methods = controllerClass.getMethods();
                if (ArrayUtil.isNotEmpty(methods)) {
                    //遍历这些Controller 类中的方法
                    for (Method method : methods) {
                        //判断当前类是否有Action 注解
                        if (method.isAnnotationPresent(Action.class)) {
                            Action action = method.getAnnotation(Action.class);
                            String mapping = action.value();
                            //验证URL 映射规则
                            if (mapping.matches("\\w:/\\w*")) {
                                String[] array = mapping.split(":");
                                if (ArrayUtil.isNotEmpty(array)) {
                                    //获取请求方法与请求路径
                                    String requestMethod = array[0];
                                    String requestPath = array[1];
                                    Request request = new Request(requestMethod, requestPath);
                                    Handler handler = new Handler(controllerClass, method);
                                    //初始化 Action Map
                                    ACTION_MAP.put(request, handler);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    /**
     * 获取 Handler
     *
     * @param requestMethod
     * @param requestPath
     * @return
     */
    public static Handler getHandler(String requestMethod, String requestPath) {
        Request request = new Request(requestMethod, requestPath);
        return ACTION_MAP.get(request);
    }
}
