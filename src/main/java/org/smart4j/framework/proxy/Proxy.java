package org.smart4j.framework.proxy;

/**
 * 代理接口
 * Created by Administrator on 2015/9/29.
 */
public interface Proxy {
    Object doProxy(ProxyChain proxyChain) throws Throwable;
}
