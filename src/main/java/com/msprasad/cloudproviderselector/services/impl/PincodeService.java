package com.msprasad.cloudproviderselector.services.impl;

import com.msprasad.cloudproviderselector.dao.PincodeDao;
import com.msprasad.cloudproviderselector.models.common.Pincode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisShardInfo;

import javax.annotation.PostConstruct;
import java.util.Map;

@Service
public class PincodeService implements PincodeDao {

    private static final String CACHE_NAME = "Pincode";

    private RedisTemplate<String, Object> redisTemplate;

    private HashOperations<String, Long, Pincode> hashOperations;

    boolean useSsl = true;
    String cacheHostname = "cloud-provider-selector.redis.cache.windows.net";
    String cachekey = "";

    // Connect to the Azure Cache for Redis over the TLS/SSL port using the key.
    JedisShardInfo shardInfo = new JedisShardInfo(cacheHostname, 6380, useSsl);
    Jedis jedis = null;

    @Autowired
    public PincodeService(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @PostConstruct
    private void intializeHashOperations() {
        shardInfo.setPassword(cachekey);
        jedis = new Jedis(shardInfo);
        jedis.auth(cachekey);
//        hashOperations = redisTemplate.opsForHash();
        jedis.connect();
        System.out.println( "Cache Response : " + jedis.ping());
    }

    @Override
    public void save(Pincode pincode) {
        System.out.println( "Cache Response : " + jedis.set(pincode.getStateName(), pincode.getPincodeVal()));
//        hashOperations.put(CACHE_NAME, pincode.getId(), pincode);
    }

    @Override
    public String find(String name) {
        System.out.println( "Cache Response : " + jedis.get(name));
        return jedis.get(name);
//        return hashOperations.get(CACHE_NAME, id);
    }

    @Override
    public void delete(String id) {
        jedis.del(id);
//        hashOperations.delete(CACHE_NAME, id);

    }

    @Override
    public String findAllPincodes() {
        System.out.println( "Cache Response : " + jedis.clientList());
        return jedis.clientList();
    }

}
