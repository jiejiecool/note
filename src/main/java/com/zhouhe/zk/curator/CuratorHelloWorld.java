package com.zhouhe.zk.curator;

import com.zhouhe.note.App;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CuratorHelloWorld {
    private static final Logger log = LoggerFactory.getLogger(CuratorHelloWorld.class);
    public static void main(String[] args) throws Exception {
        CuratorFrameworkFactory.Builder builder = CuratorFrameworkFactory.builder();
        builder.sessionTimeoutMs( 60 * 1000);
        CuratorFramework curator = builder
                .connectString("192.168.12.246:2181")
                .retryPolicy(new ExponentialBackoffRetry(1000, 10)).build();
        curator.start();

        InterProcessMutex interProcessMutex = new InterProcessMutex(curator, "/zhoujie");
        log.info("start=====================");
        interProcessMutex.acquire();
        Thread.sleep(1110000000);
    }
}
