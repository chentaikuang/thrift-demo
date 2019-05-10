package com.xiaochen.thrift.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class ServerBootstrap {
    private static Server server;

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(ServerBootstrap.class,args);
        try {
            server = context.getBean(Server.class);
            server.start();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
