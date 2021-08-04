package com.mini.rpc.provider;

import com.mini.rpc.common.RpcProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

/**
 * @Author: Dejia Meng
 * @Date: 2021/7/9 11:03
 */
@Configuration
@EnableConfigurationProperties(RpcProperties.class) // 指定属性注入
public class RpcProviderAutoConfiguration {

    @Resource
    RpcProperties rpcProperties;

    // TODO
}
