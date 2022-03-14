package com.apple.urlShortner;

import com.apple.urlShortner.model.Url;
import com.apple.urlShortner.service.UrlMapperImpl;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;


public class UrlMapperImplTest {

	@Mock
	UrlMapperImpl _urlMapperImpl;

	@Mock
	RedisTemplate<String, Url> _redisTemplate;

	@Mock
	private ValueOperations<String, Url> _valueOperations;


	@Before
	public void setUp() {
		_urlMapperImpl = Mockito.spy(new UrlMapperImpl());
		when(_redisTemplate.opsForValue()).thenReturn(_valueOperations);
		Mockito.doNothing().when(_valueOperations).set(anyString(), any(Url.class));
	}

	@Test
	public void testShortUrl() {
		String url = "www.apple.com";
		Url shortUrl = _urlMapperImpl.shortUrl(url);
		assertNotNull(shortUrl);
	}

}
