package org.ratelimiter.service;

public interface RateLimiter {
    boolean tryConsume(String key); // Attempts to consume a token for a given key
}
