package com.yql.leetcode;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.Instant;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;

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

    @Test
    public void testBitSet() {
        BitSet m = new BitSet();
        m.set(21086726);

        Map<String, BitSet> h = new HashMap<>();
        BitSet v = h.computeIfAbsent("150", k -> m);
        System.out.println(v.get(21086726));
    }
}
