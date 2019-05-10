package com.xiaochen.thrift.client;

import com.xiaochen.thrift.DateService;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransportException;

public class Client {
    private DateService.Client client;
    private TBinaryProtocol protocol;
    private TSocket transport;
    private String host;
    private int port;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public void init() {
        transport = new TSocket(host, port);
        protocol = new TBinaryProtocol(transport);
        client = new DateService.Client(protocol);
    }

    public DateService.Client getRPCThriftService() {
        return client;
    }

    public void open() throws TTransportException {
        transport.open();
    }

    public void close() {
        transport.close();
    }
}
