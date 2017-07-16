package com.learning.thrift;

/**
 * 定义发布服务接口，并实现将服务信息（服务接口、版本号，IP、port、weight）发布到zookeeper中
 * Created by topaz on 2017/7/16.
 */
public interface ThriftServerAddressRegister {

    /**
     * 发布服务接口
     * @param service 服务接口名称，一个产品中不能重复
     * @param version 服务接口的版本号，默认1.0.0
     * @param address 服务发布的地址和端口
     */
    void register(String service,String version,String address);
}
