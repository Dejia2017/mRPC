package com.mini.rpc.provider.registry;

import com.mini.rpc.common.ServiceMeta;

import java.io.IOException;

/**
 * @Author: Dejia Meng
 * @Date: 2021/7/17 11:40
 */
public interface RegistryService {
    void register(ServiceMeta serviceMeta) throws Exception;

    void unRegister(ServiceMeta serviceMeta) throws Exception;

    ServiceMeta discovery(String serviceName, int invokeHashCode) throws Exception;

    void destroy() throws IOException;
}
