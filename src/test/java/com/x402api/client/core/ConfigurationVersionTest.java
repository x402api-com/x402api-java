package com.x402api.client.core;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class ConfigurationVersionTest {
  @Test
  void runtimeVersionMatchesTheReleasedSdk() {
    assertEquals("1.3.0", Configuration.VERSION);
  }
}
