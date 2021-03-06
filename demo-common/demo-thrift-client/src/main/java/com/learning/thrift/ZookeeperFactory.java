package com.learning.thrift;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.util.StringUtils;

import java.io.File;

/**
 * 定义Zookeeper的客户端的管理
 * Created by topaz on 2017/7/16.
 */
public class ZookeeperFactory implements FactoryBean<CuratorFramework> {

    private String zkHosts;
    // session超时
    private int sessionTimeout = 30000;
    private int connectionTimeout = 30000;

    // 共享一个zk链接
    private boolean singleton = true;

    // 全局path前缀,常用来区分不同的应用
    private String namespace;

    private final static String ROOT = "rpc";

    private CuratorFramework zkClient;

    public void setZkHosts(String zkHosts) {
        this.zkHosts = zkHosts;
    }

    public void setSessionTimeout(int sessionTimeout) {
        this.sessionTimeout = sessionTimeout;
    }

    public void setConnectionTimeout(int connectionTimeout) {
        this.connectionTimeout = connectionTimeout;
    }

    public void setSingleton(boolean singleton) {
        this.singleton = singleton;
    }

    public void setNamespace(String namespace) {
        this.namespace = namespace;
    }

    public void setZkClient(CuratorFramework zkClient) {
        this.zkClient = zkClient;
    }

    @Override
    public CuratorFramework getObject() throws Exception {
        if (singleton) {
            if (zkClient == null) {
                zkClient = create();
                zkClient.start();
            }
            return zkClient;
        }
        return create();
    }

    @Override
    public Class<?> getObjectType() {
        return CuratorFramework.class;
    }

    @Override
    public boolean isSingleton() {
        return singleton;
    }

    public CuratorFramework create() throws Exception {
        if (StringUtils.isEmpty(namespace)) {
            namespace = ROOT;
        } else {
            namespace = ROOT + File.separator + namespace;
        }
        return create(zkHosts, sessionTimeout, connectionTimeout, namespace);
    }

    public static CuratorFramework create(String connectString, int sessionTimeout, int connectionTimeout, String namespace) {
        CuratorFrameworkFactory.Builder builder = CuratorFrameworkFactory.builder();
        return builder.connectString(connectString).sessionTimeoutMs(sessionTimeout).connectionTimeoutMs(30000)
                .canBeReadOnly(true).namespace(namespace).retryPolicy(new ExponentialBackoffRetry(1000, Integer.MAX_VALUE))
                .defaultData(null).build();
    }

    public void close() {
        if (zkClient != null) {
            zkClient.close();
        }
    }
}
