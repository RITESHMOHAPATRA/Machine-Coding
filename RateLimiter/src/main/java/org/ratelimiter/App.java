package org.ratelimiter;

import org.ratelimiter.factory.RateLimiterFactory;
import org.ratelimiter.service.RateLimiter;
import org.ratelimiter.service.TokenBucketRateLimiter;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String[] args) {
        // Define parameters
        int numShards = 5;
        long maxTokens = 10;
        long refillRate = 2;

        // Create a factory for ShardedTokenBucketRateLimiter
        RateLimiterFactory<TokenBucketRateLimiter> factory =
                new RateLimiterFactory<>(() -> new TokenBucketRateLimiter(numShards, maxTokens, refillRate));

        // Create a rate limiter instance
        RateLimiter rateLimiter = factory.createRateLimiter();

        // Simulate usage
        simulateRateLimiter(rateLimiter);
    }

    private static void simulateRateLimiter(RateLimiter rateLimiter) {
        Runnable task = () -> {
            String threadName = Thread.currentThread().getName();
            for (int i = 0; i < 15; i++) {
                if (rateLimiter.tryConsume(threadName)) {
                    System.out.println(threadName + " - Request allowed");
                } else {
                    System.out.println(threadName + " - Request denied");
                }

                try {
                    Thread.sleep(200); // Simulate delay
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        };

        // Run tasks in parallel threads
        Thread t1 = new Thread(task, "User-1");
        Thread t2 = new Thread(task, "User-2");
        Thread t3 = new Thread(task, "User-3");

        t1.start();
        t2.start();
        t3.start();
    }

}
