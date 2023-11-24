package com.islol.hyopgg;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class LoggingTest {
    @Test
    void testLogInfo() {
        log.info("info");
        log.debug("debug");
        System.out.println("tt");
    }

}
