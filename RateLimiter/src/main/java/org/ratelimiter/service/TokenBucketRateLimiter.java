package org.ratelimiter.service;

import java.util.concurrent.ConcurrentHashMap;

public class TokenBucketRateLimiter implements RateLimiter {
    private final int numShards;
    private final ConcurrentHashMap<Integer, TokenBucket> shardMap;

    public TokenBucketRateLimiter(int numShards, long maxTokensPerBucket, long refillRatePerBucket) {
        this.numShards = numShards;
        this.shardMap = new ConcurrentHashMap<>();

        for (int i = 0; i < numShards; i++) {
            shardMap.put(i, new TokenBucket(maxTokensPerBucket, refillRatePerBucket));
        }
    }

    @Override
    public boolean tryConsume(String key) {
        int shardIndex = getShardIndex(key);
        TokenBucket bucket = shardMap.get(shardIndex);
        return bucket.tryConsume();
    }

    private int getShardIndex(String key) {
        return Math.abs(key.hashCode() % numShards);
    }
}
