package com.kikyc.utils;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;


@Configuration
@ComponentScan(value = {"com.kikyc.utils"})
@MapperScan(value = "com.kikyc.utils.dao")
@EnableAutoConfiguration
public class SpringbootdemoApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context =   SpringApplication.run(SpringbootdemoApplication.class, args);
    }
    @Bean
    @Autowired(required = false)
    public RedisTemplate redisTemplate(RedisConnectionFactory redisConnectionFactory){

        RedisTemplate template = new RedisTemplate();
        template.setConnectionFactory(redisConnectionFactory);

    Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
    ObjectMapper om = new ObjectMapper();
        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
                om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
                jackson2JsonRedisSerializer.setObjectMapper(om);
                template.setValueSerializer(jackson2JsonRedisSerializer);
                template.setKeySerializer(new StringRedisSerializer());
                template.afterPropertiesSet();
                return template;
                }

                }
