package org.ratelimiter.service;

import java.time.Instant;
import java.util.concurrent.atomic.AtomicLong;

public class TokenBucket {
    private final long maxTokens;
    private final long refillRatePerSecond;
    private final AtomicLong currentTokens;
    private volatile Instant lastRefillTimestamp;

    public TokenBucket(long maxTokens, long refillRatePerSecond) {
        this.maxTokens = maxTokens;
        this.refillRatePerSecond = refillRatePerSecond;
        this.currentTokens = new AtomicLong(maxTokens);
        this.lastRefillTimestamp = Instant.now();
    }

    public synchronized boolean tryConsume() {
        refillTokens();
        if (currentTokens.get() > 0) {
            currentTokens.decrementAndGet();
            return true;
        }
        return false;
    }

    private void refillTokens() {
        Instant now = Instant.now();
        long secondsSinceLastRefill = lastRefillTimestamp.until(now, java.time.temporal.ChronoUnit.SECONDS);
        if (secondsSinceLastRefill > 0) {
            long tokensToAdd = secondsSinceLastRefill * refillRatePerSecond;
            long newTokenCount = Math.min(maxTokens, currentTokens.get() + tokensToAdd);
            currentTokens.set(newTokenCount);
            lastRefillTimestamp = now;
        }
    }
}

