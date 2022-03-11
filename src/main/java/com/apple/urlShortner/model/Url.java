package com.apple.urlShortner.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

import java.time.LocalDateTime;


@Data
@Builder
public class Url {

	@NonNull
	private String url;

	@NonNull
	private String key;

	@JsonSerialize
	@JsonDeserialize
	private LocalDateTime created;

}
