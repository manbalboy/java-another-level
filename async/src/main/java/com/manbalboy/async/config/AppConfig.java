package com.manbalboy.async.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@Configuration
public class AppConfig {


    @Bean("async-thread")
    public Executor asyncThread() {
        ThreadPoolTaskExecutor threadPooltaskExecutor = new ThreadPoolTaskExecutor();
        threadPooltaskExecutor.setMaxPoolSize(100);
        threadPooltaskExecutor.setCorePoolSize(10);
        threadPooltaskExecutor.setQueueCapacity(10);
        threadPooltaskExecutor.setThreadNamePrefix("Async-");
        return threadPooltaskExecutor;
    }

}
