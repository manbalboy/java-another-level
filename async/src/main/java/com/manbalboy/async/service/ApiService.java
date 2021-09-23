package com.manbalboy.async.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ApiService {
    @Async
    public void hello() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(2000);
                log.info("service");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
