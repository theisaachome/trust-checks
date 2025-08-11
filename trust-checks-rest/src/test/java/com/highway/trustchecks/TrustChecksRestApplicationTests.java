package com.highway.trustchecks;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.assertj.ApplicationContextAssertProvider;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ActiveProfiles;

import java.util.Arrays;

@SpringBootTest
@ActiveProfiles("test")
class TrustChecksRestApplicationTests {

    @Autowired
    private Environment env;

    @Test
    void contextLoads() {
    }

    @Test
    void checkActiveProfiles() {
        System.out.println("Active profiles: " + Arrays.toString(env.getActiveProfiles()));
    }
}
