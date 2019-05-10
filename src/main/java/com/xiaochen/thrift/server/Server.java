package com.xiaochen.thrift.server;


import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TServerTransport;
import org.apache.thrift.transport.TTransportFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;


@Component
public class Server {

    //protected final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Value("${thrift.port}")
    private int port;
    @Value("${thrift.minWorkerThreads}")
    private int minThreads;
    @Value("${thrift.maxWorkerThreads}")
    private int maxThreads;

    private TBinaryProtocol.Factory protocolFactory;
    private TTransportFactory transportFactory;

    @Autowired
    private DateServiceImpl DateService;

    public void init(){
        protocolFactory = new TBinaryProtocol.Factory();
        transportFactory = new TTransportFactory();
    }

    public void start(){
        com.xiaochen.thrift.DateService.Processor processor = new com.xiaochen.thrift.DateService.Processor<com.xiaochen.thrift.DateService.Iface>(DateService);
        init();
        try{
            TServerTransport transport = new TServerSocket(port);
            TThreadPoolServer.Args tArgs = new TThreadPoolServer.Args(transport);
            tArgs.processor(processor);
            tArgs.transportFactory(transportFactory);
            tArgs.minWorkerThreads(minThreads);
            tArgs.maxWorkerThreads(maxThreads);
            tArgs.requestTimeout(2);
            tArgs.requestTimeoutUnit(TimeUnit.MILLISECONDS);
            TServer server = new TThreadPoolServer(tArgs);
//            logger.info("hello",port);
            server.serve();
        } catch (Exception e){
//            logger.error("Exception occured",e);
        }
    }
}