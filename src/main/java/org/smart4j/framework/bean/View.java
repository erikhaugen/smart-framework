package org.smart4j.framework.bean;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2015/9/28.
 */
public class View {
    /**
     * ��ͼ·��
     */
    private String path;
    /**
     * ģ������
     */
    private Map<String, Object> model;

    public View(String path) {
        this.path = path;
        this.model = new HashMap<String, Object>();
    }

    public View addModel(String key, Object value) {
        model.put(key, value);
        return this;
    }

    public Map<String, Object> getModel() {
        return model;
    }

    public String getPath() {
        return path;
    }
}
