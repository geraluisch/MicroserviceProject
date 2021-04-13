package com.escalab.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.escalab.filters.HeaderPreFilter;
import com.escalab.filters.LogPrefilter;
import com.escalab.filters.RequestPostFilter;

@Configuration
public class ApplicationConfig {	
	
	@Bean
	public HeaderPreFilter headerPreFilter() {
		return new HeaderPreFilter();
	}
	
	@Bean
	public LogPrefilter logPrefilter() {
		return new LogPrefilter();
	}
	
	@Bean
	public RequestPostFilter requestPostFilter() {
		return new RequestPostFilter();
	}

}
