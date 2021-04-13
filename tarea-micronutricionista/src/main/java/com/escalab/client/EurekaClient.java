package com.escalab.client;

import java.net.URI;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Component;

@Component("EurekaClient")
public class EurekaClient{

    @Autowired
    private DiscoveryClient discoveryClient;

    public List<ServiceInstance> getUri(String serviceName) {
    	List<ServiceInstance> list = discoveryClient.getInstances(serviceName);
        if (list != null && list.size() > 0 ) {
            return list;
        }
        return null;
    }
}
