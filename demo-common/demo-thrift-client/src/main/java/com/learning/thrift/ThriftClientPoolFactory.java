package com.learning.thrift;

import org.apache.commons.pool.BasePoolableObjectFactory;
import org.apache.thrift.TServiceClient;
import org.apache.thrift.TServiceClientFactory;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;

import java.net.InetSocketAddress;

/**
 * 客户端连接池实现
 * Created by topaz on 2017/7/10.
 */
public class ThriftClientPoolFactory extends BasePoolableObjectFactory<TServiceClient> {

    private final ThriftServerAddressProvider serverAddressProvider;
    private final TServiceClientFactory<TServiceClient> clientFactory;
    private PoolOperationCallBack callback;

    protected ThriftClientPoolFactory(ThriftServerAddressProvider addressProvider, TServiceClientFactory<TServiceClient> clientFactory) throws Exception {
        this.serverAddressProvider = addressProvider;
        this.clientFactory = clientFactory;
    }

    protected ThriftClientPoolFactory(ThriftServerAddressProvider addressProvider, TServiceClientFactory<TServiceClient> clientFactory,
                                      PoolOperationCallBack callback) throws Exception {
        this.serverAddressProvider = addressProvider;
        this.clientFactory = clientFactory;
        this.callback = callback;
    }

    static interface PoolOperationCallBack {
        // 销毁client之前执行
        void destroy(TServiceClient client);

        // 创建成功是执行
        void make(TServiceClient client);
    }

    public void destroyObject(TServiceClient client) throws Exception {
        if (callback != null) {
            try {
                callback.destroy(client);
            } catch (Exception e) {
                //
            }
        }
        TTransport pin = client.getInputProtocol().getTransport();
        pin.close();
    }

    public boolean validateObject(TServiceClient client) {
        TTransport pin = client.getInputProtocol().getTransport();
        return pin.isOpen();
    }

    @Override
    public TServiceClient makeObject() throws Exception {
        InetSocketAddress address = serverAddressProvider.selector();
        TSocket tsocket = new TSocket(address.getHostName(), address.getPort());
        TTransport transport = new TFramedTransport(tsocket);
        TProtocol protocol = new TBinaryProtocol(transport);
        TServiceClient client = this.clientFactory.getClient(protocol);
        transport.open();
        if (callback != null) {
            try {
                callback.make(client);
            } catch (Exception e) {
                //
            }
        }
        return client;
    }

}