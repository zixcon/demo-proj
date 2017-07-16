package com.learning.thrift;

/**
 * 由于服务端配置需要获取本机的IP地址，因此定义IP获取接口
 * Created by topaz on 2017/7/16.
 */
public interface ThriftServerIpResolve {

    String getServerIp() throws Exception;

    void reset();

    //当IP变更时,将会调用reset方法
    static interface IpRestCalllBack {
        public void rest(String newIp);
    }
}
