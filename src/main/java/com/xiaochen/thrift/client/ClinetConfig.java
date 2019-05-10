package com.xiaochen.thrift.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ClinetConfig {
    @Value("${thrift.host}")
    private String host;
    @Value("${thrift.port}")
    private int port;

    @Bean(initMethod = "init")
    public Client initThriftClient() {
        Client client = new Client();
        client.setHost(host);
        client.setPort(port);
        return client;
    }
}
