package com.tyw.springcloud.rule;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Configuration
public class MySelfRule {

    @Bean
    public IRule myRule()
    {
        return new MyRule();
    }

}


