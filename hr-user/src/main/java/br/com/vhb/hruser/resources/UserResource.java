package br.com.vhb.hruser.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.vhb.hruser.entities.User;
import br.com.vhb.hruser.repositories.UserRepository;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

	@Autowired
	private UserRepository repository;

	@GetMapping(value = "/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id) throws NotFoundException {
		User user = repository.findById(id).orElseThrow(NotFoundException::new);
		return ResponseEntity.ok(user);
	}

	@GetMapping(value = "/search")
	public ResponseEntity<User> findById(@RequestParam String email) throws NotFoundException {
		User user = repository.findByEmail(email).orElseThrow(NotFoundException::new);
		return ResponseEntity.ok(user);
	}

}
