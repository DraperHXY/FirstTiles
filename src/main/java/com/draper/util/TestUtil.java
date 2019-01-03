package com.draper.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class TestUtil {

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    public void sayHello() {
        LOGGER.warn("hello");
    }

}
