package com.hscastro.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import com.hscastro.example.entities.Book;


@Configuration
public class ConfigRedis {

	
	//Creating Connection with Redis
	@Bean
	public RedisConnectionFactory getRedisConnectionFactory() {
		return new LettuceConnectionFactory();
	}
	
	//Creating RedisTemplate for Entity 'Book'
	@Bean
	public RedisTemplate<String, Book> redisTemplate(){
		RedisTemplate<String, Book> bookTemplate = new RedisTemplate<String, Book>();
		
		bookTemplate.setConnectionFactory(getRedisConnectionFactory());
		return bookTemplate;
	}
	
}
