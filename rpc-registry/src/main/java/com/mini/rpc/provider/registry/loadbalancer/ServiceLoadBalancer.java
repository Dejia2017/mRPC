package com.mini.rpc.provider.registry.loadbalancer;

import java.util.List;

/**
 * @Author: Dejia Meng
 * @Date: 2021/7/23 17:14
 */
public interface ServiceLoadBalancer<T> {
    T select(List<T> servers, int hashCode);
}
