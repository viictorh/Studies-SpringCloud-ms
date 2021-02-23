package br.com.vhb.hroauth.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import br.com.vhb.hroauth.entities.User;
import br.com.vhb.hroauth.feignclients.UserFeignClient;

@Service
public class UserService implements UserDetailsService {

	@Autowired
	private UserFeignClient userFeignClient;

	public User findByEmail(String email) {
		return userFeignClient.findByEmail(email).getBody();
	}

	@Override
	public UserDetails loadUserByUsername(String username) {
		return findByEmail(username);
	}

}
