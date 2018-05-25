package com.fineframework.component.session;

import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

@EnableRedisHttpSession(maxInactiveIntervalInSeconds=60)
public class SessionConfig {
	
}
