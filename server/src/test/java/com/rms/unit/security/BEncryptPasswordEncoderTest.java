package com.rms.unit.security;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BEncryptPasswordEncoderTest {

        /**
         * Ensure that the encoder has not changed when we upgrade the versions 
         * of libraries
         */
        @Test
        public void test() {
                BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
                assertTrue(passwordEncoder.matches("kidnap_president#", 
                    "$2a$10$878AEpyzAIo4VNmMvAywjeY2JbkNyT.m4XE9WDVSnNX9FVRpFlKwq"));
        }

}
