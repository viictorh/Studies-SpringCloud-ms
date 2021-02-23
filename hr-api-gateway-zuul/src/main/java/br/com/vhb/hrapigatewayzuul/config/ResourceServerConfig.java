package br.com.vhb.hrapigatewayzuul.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@EnableResourceServer
@Configuration
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

	@Autowired
	private JwtTokenStore tokenStore;

	private static final String[] PUBLIC = { "/hr-oauth/oauth/token", };
	private static final String[] OPERATOR = { "/hr-worker/**", };
	private static final String[] ADMIN = { "/hr-payroll/**", "/hr-user/**", "/actuator/**",
			"/hr-worker/actuator/**", "/hr-oauth/actuator/**" };

	@Override
	public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
		resources.tokenStore(tokenStore);
	}

	@Override
	public void configure(HttpSecurity http) throws Exception {
		// permite tudo do do PUBLIC mesmo que não esteja logado
		http.authorizeRequests().antMatchers(PUBLIC).permitAll()
				// Permite a rota OPERATOR para qualquer usuário que tenha os "ROLES" operador
				// ou admin apenas utilizando GET
				.antMatchers(HttpMethod.GET, OPERATOR).hasAnyRole("OPERATOR", "ADMIN")
				// Permite a rota ADMIN apenas para quem tiver o "ROLE" admin
				.antMatchers(ADMIN).hasRole("ADMIN")
				// Qualquer outra rota não mencionada, precisa estar autenticado
				.anyRequest().authenticated();

	}
}
