package com.mini.rpc.provider.registry;

/**
 * @Author: Dejia Meng
 * @Date: 2021/7/17 11:39
 */
public class RegistryFactory {

    private static volatile RegistryService registryService;

    /**
     * 单例模式 双检锁实现 提供了可选项 所以命名成了工厂
     *
     * @return
     */
    public static RegistryService getInstance(String registryAddr, RegistryType registryType) throws Exception {
        if (null == registryService) {
            synchronized (RegistryFactory.class) {
                if (null == registryService) {
                    switch (registryType) {
                        case EUREKA:
                            registryService = new EurekaRegistryService(registryAddr);
                            break;
                        case ZOOKEEPER:
                            registryService = new ZookeeperRegistryService(registryAddr);
                            break;
                        default:
                            throw new RuntimeException("not support type " + registryType);
                    }
                }
            }
        }
        return registryService;
    }
}
