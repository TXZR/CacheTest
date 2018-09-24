package com.tyw.springcloud.rule;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class MyRule extends AbstractLoadBalancerRule {

    private AtomicInteger index = new AtomicInteger(0);

    private AtomicInteger total = new AtomicInteger(0);

    public Server choose(ILoadBalancer lb, Object key) {
        if (lb == null) {
            return null;
        } else {
            Server server = null;

            while(server == null) {
                if (Thread.interrupted()) {
                    return null;
                }

                List<Server> upList = lb.getReachableServers();
                List<Server> allList = lb.getAllServers();

                int serverCount = allList.size();
                if (serverCount == 0) {
                    return null;
                }

                if(total.compareAndSet(5, 0)){
                    index.addAndGet(1);
                    index.compareAndSet(allList.size(), 0);
                }
                server = upList.get(index.get());

                if (server == null) {
                    Thread.yield();
                } else {
                    if (server.isAlive()) {
                        total.addAndGet(1);
                        return server;
                    }
                    server = null;
                    Thread.yield();
                }
            }

            return server;
        }
    }

    public Server choose(Object key) {
        return this.choose(this.getLoadBalancer(), key);
    }

    public void initWithNiwsConfig(IClientConfig clientConfig) {
    }
}
