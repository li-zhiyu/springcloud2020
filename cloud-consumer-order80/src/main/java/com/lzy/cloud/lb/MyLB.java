package com.lzy.cloud.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Ribbon手写轮询算法
 *
 * @author zzyy
 * @date 2020/3/6 16:05
 **/
@Component
public class MyLB implements LoadBalancer {
    private AtomicInteger atomicInteger = new AtomicInteger(0);

    public final int getAndIncrement() {
        int current;
        int next;
        do {
            current = this.atomicInteger.get();
            int i = atomicInteger.incrementAndGet();
            // 超过最大值,为0,重新计数 2147483647 Integer.MAX_VALUE
            next = current >= Integer.MAX_VALUE ? 0 : current + 1;
            // 自旋锁
        } while (!atomicInteger.compareAndSet(current, next));//如果当前值等于期望值表示没有其他线程修改过，则更新；否则重新取值，重新计算，重新去比较
        System.out.println("****第几次访问,次数next:" + next);
        return next;
    }

    /**
     * 负载均衡算法:rest接口第几次请求数%服务器集群总数量=实际调用服务器位置下标,每次服务重启动后rest接口计数从1开始.
     *
     * @param serviceInstances
     * @return
     */
    @Override
    public ServiceInstance instances(List<ServiceInstance> serviceInstances) {
        int index = getAndIncrement() % serviceInstances.size();
        return serviceInstances.get(index);
    }
}
