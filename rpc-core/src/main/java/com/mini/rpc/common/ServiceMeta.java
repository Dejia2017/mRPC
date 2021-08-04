package com.mini.rpc.common;

import lombok.Data;

/**
 * @Author: Dejia Meng
 * @Date: 2021/7/17 13:37
 */
@Data
public class ServiceMeta {
    private String serviceName;
    private String serviceAddr;
    private int servicePort;
    private String serviceVersion;
}
