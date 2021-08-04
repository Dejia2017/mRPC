package com.mini.rpc.common;

/**
 * @Author: Dejia Meng
 * @Date: 2021/8/3 15:13
 */
public class RpcServiceHelper {
    public static String buildServiceKey(String serviceName, String serviceVersion) {
        return String.join("#", serviceName, serviceVersion);
    }
}
