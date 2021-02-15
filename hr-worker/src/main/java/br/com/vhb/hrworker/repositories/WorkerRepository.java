package br.com.vhb.hrworker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.vhb.hrworker.entities.Worker;

public interface WorkerRepository extends JpaRepository<Worker, Long> {

}
