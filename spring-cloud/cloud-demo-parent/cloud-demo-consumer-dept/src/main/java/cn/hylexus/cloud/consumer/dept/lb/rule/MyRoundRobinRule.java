package cn.hylexus.cloud.consumer.dept.lb.rule;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;

import java.util.List;

public class MyRoundRobinRule extends AbstractLoadBalancerRule {

    private static final int MAX_COUNT = 3;
    private int currentCount = 0;
    private int currentIndex = 0;

    @SuppressWarnings({"RCN_REDUNDANT_NULLCHECK_OF_NULL_VALUE"})
    public Server choose(ILoadBalancer lb, Object key) {
        if (lb == null) {
            return null;
        }

        Server server = null;
        while (server == null) {
            if (Thread.interrupted()) {
                return null;
            }

            List<Server> upList = lb.getReachableServers();
            List<Server> allList = lb.getAllServers();
            int serverCount = allList.size();
            if (serverCount == 0) {
                return null;
            }

            server = upList.get(currentIndex);

            currentCount++;

            if (currentCount >= MAX_COUNT) {
                currentCount = 0;
                currentIndex++;
            }

            if (currentIndex >= serverCount) {
                currentIndex = 0;
            }

            if (server == null) {
                Thread.yield();
            } else {
                if (server.isAlive()) {
                    return server;
                }
                server = null;
                Thread.yield();
            }
        }

        return server;
    }

    public Server choose(Object key) {
        return this.choose(this.getLoadBalancer(), key);
    }

    public void initWithNiwsConfig(IClientConfig clientConfig) {
    }
}