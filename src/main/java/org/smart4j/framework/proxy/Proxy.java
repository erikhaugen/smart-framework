package org.smart4j.framework.proxy;

/**
 * ����ӿ�
 * Created by Administrator on 2015/9/29.
 */
public interface Proxy {
    Object doProxy(ProxyChain proxyChain) throws Throwable;
}
