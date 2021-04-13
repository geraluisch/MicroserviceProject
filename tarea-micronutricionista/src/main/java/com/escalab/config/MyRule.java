package com.escalab.config;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;

import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.Server;


public class MyRule implements IRule {
	
	@Autowired
	private DiscoveryClient discoveryClient;

	private ILoadBalancer lb;	
	
	@Override	
	public Server choose(Object key) {

       // List<Server> servers =  
        		
        List<ServiceInstance> servers = discoveryClient.getInstances("MICRO-PACIENTE"); //lb.getAllServers();
        Random r = new Random();
        int rand = r.nextInt(servers.size());
        Server servidor = new Server(servers.get(rand).getHost(), servers.get(rand).getPort());
        return servidor;
        /*int rand = r.nextInt(10);
        if(rand > 5){
        	Server servidor = new Server(servers.get(0).getHost(), servers.get(0).getPort());
            return servidor;//getServerByPort(servers, servers.get(0).getPort());
        }else{
            Server servidor = new Server(servers.get(1).getHost(), servers.get(1).getPort());
            return servidor;//servers.get(1).;//getServerByPort(servers, servers.get(1).getPort());
        }*/
	}

	@Override
	public void setLoadBalancer(ILoadBalancer lb) {
		 this.lb = lb;	
	}

	@Override
	public ILoadBalancer getLoadBalancer() {
		  return this.lb;
	}
	
	/*private ServiceInstance getServerByPort(List<ServiceInstance> servers, int port){
        for(ServiceInstance s : servers){
            if(s.getPort() == port){
                return s;
            }
        }
        return null;
    }*/

}
