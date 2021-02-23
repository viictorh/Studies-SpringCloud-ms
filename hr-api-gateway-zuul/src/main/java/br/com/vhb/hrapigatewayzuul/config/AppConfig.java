package br.com.vhb.hrapigatewayzuul.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@RefreshScope
@Configuration
public class AppConfig {

	@Value("${jwt.secret}")
	private String secretKey;

	@Bean
	public JwtAccessTokenConverter getJwtAccessTokenConverter() {
		JwtAccessTokenConverter tokenConverter = new JwtAccessTokenConverter();
		tokenConverter.setSigningKey(secretKey);
		return tokenConverter;
	}

	@Bean
	public JwtTokenStore getTokenStore() {
		return new JwtTokenStore(getJwtAccessTokenConverter());
	}

}
