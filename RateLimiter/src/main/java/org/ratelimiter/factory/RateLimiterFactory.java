package org.ratelimiter.factory;

import org.ratelimiter.service.RateLimiter;

import java.util.function.Supplier;

public class RateLimiterFactory<T extends RateLimiter> {
    private final Supplier<T> constructor;

    public RateLimiterFactory(Supplier<T> constructor) {
        this.constructor = constructor;
    }

    public T createRateLimiter() {
        return constructor.get();
    }
}

