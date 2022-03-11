package com.apple.urlShortner.service;

import com.apple.urlShortner.model.Url;
import com.google.common.hash.Hashing;
import lombok.NonNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.nio.charset.Charset;
import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

@Service
public class UrlMapperImpl implements UrlMapper{

	private static final Logger _log = LoggerFactory.getLogger(UrlMapperImpl.class);

	@Autowired
	private RedisTemplate<String, Url> redisTemplate;

	@Override
	public String getUrl(@NonNull String key) {
		_log.info("Getting original url for " + key);
		Url url = redisTemplate.opsForValue().get(key);
		return url != null ? url.getUrl() : "";
	}

	@Override
	public Url shortUrl(@NonNull String url) {
		// using google's hashing algorithm for shortening a url
		String key = Hashing.murmur3_32().hashString(url, Charset.defaultCharset()).toString();
		Url shortUrl = Url.builder().key(key).created(LocalDateTime.now()).url(url).build();

		//storing in redis
		redisTemplate.opsForValue().set(key, shortUrl, 36000L, TimeUnit.SECONDS);

		return shortUrl;
	}
}
