package com.mini.rpc.provider.registry;

import com.mini.rpc.common.ServiceMeta;

import java.io.IOException;

/**
 * @Author: Dejia Meng
 * @Date: 2021/7/17 13:43
 */
public class EurekaRegistryService implements RegistryService {
    public EurekaRegistryService(String registryAddr) {
    }

    @Override
    public void register(ServiceMeta serviceMeta) throws Exception {

    }

    @Override
    public void unRegister(ServiceMeta serviceMeta) throws Exception {

    }

    @Override
    public ServiceMeta discovery(String serviceName, int invokeHashCode) throws Exception {
        return null;
    }

    @Override
    public void destroy() throws IOException {

    }
}
