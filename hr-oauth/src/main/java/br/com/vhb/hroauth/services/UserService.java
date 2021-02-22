package br.com.vhb.hroauth.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.vhb.hroauth.entities.User;
import br.com.vhb.hroauth.feignclients.UserFeignClient;

@Service
public class UserService {

	@Autowired
	private UserFeignClient userFeignClient;

	public User findByEmail(String email) {
		return userFeignClient.findByEmail(email).getBody();
	}

}
