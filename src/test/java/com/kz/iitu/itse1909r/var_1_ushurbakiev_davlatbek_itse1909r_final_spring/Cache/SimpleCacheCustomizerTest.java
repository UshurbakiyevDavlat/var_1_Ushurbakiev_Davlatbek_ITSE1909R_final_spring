package com.kz.iitu.itse1909r.var_1_ushurbakiev_davlatbek_itse1909r_final_spring.Cache;

import org.junit.jupiter.api.Test;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;

class SimpleCacheCustomizerTest {
    SimpleCacheCustomizer simpleCacheCustomizer = new SimpleCacheCustomizer();

    @Test
    void testCustomize() {
        simpleCacheCustomizer.customize(new ConcurrentMapCacheManager());
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme