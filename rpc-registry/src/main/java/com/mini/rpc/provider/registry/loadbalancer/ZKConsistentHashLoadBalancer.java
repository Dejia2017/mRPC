package com.mini.rpc.provider.registry.loadbalancer;

import com.mini.rpc.common.ServiceMeta;
import org.apache.curator.x.discovery.ServiceInstance;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @Author: Dejia Meng
 * @Date: 2021/7/23 17:14
 */
public class ZKConsistentHashLoadBalancer implements ServiceLoadBalancer<ServiceInstance<ServiceMeta>> {
    private static final int VIRTUAL_NODE_NUM = 10;
    private static final String VIRTUAL_NODE_SPLIT = "#";
    /**
     *
     * @param servers
     * @param hashCode
     * @return
     */
    @Override
    public ServiceInstance<ServiceMeta> select(List<ServiceInstance<ServiceMeta>> servers, int hashCode) {
        TreeMap<Integer, ServiceInstance<ServiceMeta>> ring = makeConsistentHashRing(servers);
        return allocateNode(ring, hashCode);
    }

    ServiceInstance<ServiceMeta> allocateNode(TreeMap<Integer, ServiceInstance<ServiceMeta>> ring, int hashCode) {
        Map.Entry<Integer, ServiceInstance<ServiceMeta>> entry = ring.ceilingEntry(hashCode);
        if (entry == null) {
            entry = ring.firstEntry();
        }
        return entry.getValue();
    }

    private TreeMap<Integer, ServiceInstance<ServiceMeta>> makeConsistentHashRing(List<ServiceInstance<ServiceMeta>> servers) {
        TreeMap<Integer, ServiceInstance<ServiceMeta>> ring = new TreeMap<>();
        for (ServiceInstance<ServiceMeta> serviceInstance : servers) {
            for (int i = 0; i < VIRTUAL_NODE_NUM; i++) {
                ring.put((buildInstanceHashKey(serviceInstance) + VIRTUAL_NODE_SPLIT + i).hashCode(), serviceInstance);
            }
        }
        return ring;
    }

    private String buildInstanceHashKey(ServiceInstance<ServiceMeta> serviceInstance) {
        ServiceMeta payload = serviceInstance.getPayload();
        return String.join(":", payload.getServiceAddr(), String.valueOf(payload.getServicePort()));
    }
}
