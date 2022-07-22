package com.yql.leetcode;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.Instant;

public class BitMapTest {
    private static final Logger log = LogManager.getLogger(BitMapTest.class);

    @Test
    public void testBitMap() {
        BitMap<String> m = new BitMap<>();
        String key;
        Instant start = Instant.now();
        for (int i = 0; i < 100000; i++) {
            key = String.format("%s-%d", "hi", i);
            m.set(key);
            if (!m.contains(key)) {
                throw new RuntimeException("not pass");
            }
        }
        Instant finish = Instant.now();
        log.info("pass in " + Duration.between(start, finish).toMillis() + "ms, processed:" + m.getWordCount());
    }
}
