package com.apple.urlShortner.controller;

import com.apple.urlShortner.model.Url;
import com.apple.urlShortner.service.UrlMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/shortUrl")
public class UrlController {

	@Autowired
	private UrlMapper urlMapper;

	@RequestMapping(value = "/{url}", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity urlShortner (@PathVariable String url) {
		Url shortUrl = urlMapper.shortUrl(url);
		return ResponseEntity.ok(shortUrl);
	}

	@RequestMapping(value = "/{key}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity getUrl(@PathVariable String key) {
		String url = urlMapper.getUrl(key);
		return ResponseEntity.ok(url);
	}
}
