package com.apple.urlShortner.config;

import com.apple.urlShortner.model.Url;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class RedisConfig {

	@Autowired
	ObjectMapper _objectMapper;

	@Autowired
	RedisConnectionFactory _redisConnectionFactory;

	@Bean
	public RedisTemplate<String, Url> redisTemplate() {
		final RedisTemplate<String, Url> redisTemplate = new RedisTemplate<>();

		Jackson2JsonRedisSerializer redisValueSerializer = new Jackson2JsonRedisSerializer(Url.class);

		redisValueSerializer.setObjectMapper(_objectMapper);

		redisTemplate.setConnectionFactory(_redisConnectionFactory);
		redisTemplate.setKeySerializer(new StringRedisSerializer());
		redisTemplate.setValueSerializer(redisValueSerializer);

		return redisTemplate;

	}
}
