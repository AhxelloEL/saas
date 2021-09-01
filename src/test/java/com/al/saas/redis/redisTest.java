package com.al.saas.redis;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * @author Xiahuicheng
 * @PackageName:com.al.saas.redis
 * @ClassName:redisTest
 * @Description
 * @date2021/8/31 18:26
 */
@SpringBootTest
public class redisTest {
    @Autowired
    RedisTemplate redisTemplate;

    @Test
    public void testGet(){
        redisTemplate.opsForValue().set("xhc","夏慧城");
        System.out.println(redisTemplate.opsForValue().get("xhc"));
    }
}
