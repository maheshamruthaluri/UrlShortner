package com.apple.urlShortner.service;

import com.apple.urlShortner.model.Url;
import lombok.NonNull;

public interface UrlMapper {

	public String getUrl(@NonNull String key);

	public Url shortUrl(@NonNull String url);
}
