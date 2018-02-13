package com.rms.unit.security;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BEncryptPasswordEncoderTest {

	/**
	 * Ensure that the encoder has not changed when we upgarde the versions 
	 * of libraries
	 */
	@Test
	public void test() {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String hashedPassword = passwordEncoder.encode("kidnap_president#");
		assertEquals("$2a$10$878AEpyzAIo4VNmMvAywjeY2JbkNyT.m4XE9WDVSnNX9FVRpFlKwq",hashedPassword);
	}

}
