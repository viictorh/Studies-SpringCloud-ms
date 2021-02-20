package br.com.vhb.hrpayroll.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.vhb.hrpayroll.entities.Payment;
import br.com.vhb.hrpayroll.entities.Worker;
import br.com.vhb.hrpayroll.feignclients.WorkerFeignClient;

//seria equivalente ao @Component, mas por questão de semantica usa-se @service
@Service
public class PaymentService {

	@Autowired
	private WorkerFeignClient workerFeignClient;

	public Payment getPayment(long workerId, int days) {
		Worker worker = workerFeignClient.findById(workerId).getBody();
		return new Payment(worker.getName(), worker.getDailyIncome(), days);
	}
}
