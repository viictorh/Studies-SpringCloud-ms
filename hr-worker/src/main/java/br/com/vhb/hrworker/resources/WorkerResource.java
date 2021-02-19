package br.com.vhb.hrworker.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.vhb.hrworker.entities.Worker;
import br.com.vhb.hrworker.repositories.WorkerRepository;

@RestController
@RequestMapping(value = "/workers")
public class WorkerResource {

	@Autowired
	private WorkerRepository workerRepository;

	@GetMapping
	public ResponseEntity<List<Worker>> findAll() {
		List<Worker> list = workerRepository.findAll();
		return ResponseEntity.ok(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Worker> findById(@PathVariable Long id) throws NotFoundException {
		Worker worker = workerRepository.findById(id).orElseThrow(NotFoundException::new);
		return ResponseEntity.ok(worker);
	}

}