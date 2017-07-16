package com.learning.thrift;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

/**
 * 基于网卡获取IP地址，也可以通过配置serverIp
 * Created by topaz on 2017/7/16.
 */
public class ThriftServerIpLocalNetworkResolve  implements ThriftServerIpResolve {

    private Logger logger = LoggerFactory.getLogger(getClass());

    //缓存
    private String serverIp;

    public void setServerIp(String serverIp) {
        this.serverIp = serverIp;
    }

    @Override
    public String getServerIp() {
        if (serverIp != null) {
            return serverIp;
        }
        // 一个主机有多个网络接口
        try {
            Enumeration<NetworkInterface> netInterfaces = NetworkInterface.getNetworkInterfaces();
            while (netInterfaces.hasMoreElements()) {
                NetworkInterface netInterface = netInterfaces.nextElement();
                // 每个网络接口,都会有多个"网络地址",比如一定会有lookback地址,会有siteLocal地址等.以及IPV4或者IPV6 .
                Enumeration<InetAddress> addresses = netInterface.getInetAddresses();
                while (addresses.hasMoreElements()) {
                    InetAddress address = addresses.nextElement();
                    if(address instanceof Inet6Address){
                        continue;
                    }
                    if (address.isSiteLocalAddress() && !address.isLoopbackAddress()) {
                        serverIp = address.getHostAddress();
                        logger.info("resolve server ip :"+ serverIp);
                        continue;
                    }
                }
            }
        } catch (SocketException e) {
            logger.error(e.getMessage(),e);
        }
        return serverIp;
    }

    @Override
    public void reset() {
        serverIp = null;
    }
}