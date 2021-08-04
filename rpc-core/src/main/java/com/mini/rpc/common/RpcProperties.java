package com.mini.rpc.common;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @Author: Dejia Meng
 * @Date: 2021/7/9 11:04
 */
@Data
@ConfigurationProperties(prefix = "rpc")
public class RpcProperties {
    private String servicePort;
    private String registryAddr;
    private String registryType;
}
