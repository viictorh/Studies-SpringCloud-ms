package br.com.vhb.hrpayroll.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import br.com.vhb.hrpayroll.entities.Payment;
import br.com.vhb.hrpayroll.services.PaymentService;

@RestController
@RequestMapping(value = "/payments")
public class PaymentResources {

	@Autowired
	private PaymentService service;

	@HystrixCommand(fallbackMethod = "getPaymentFallBack")
	@GetMapping(value = "/{workerId}/days/{days}")
	public ResponseEntity<Payment> getPayment(@PathVariable Long workerId, @PathVariable Integer days) {
		Payment payment = service.getPayment(workerId, days);
		return ResponseEntity.ok(payment);
	}

	public ResponseEntity<Payment> getPaymentFallBack(Long workerId, Integer days) {
		Payment payment = new Payment("FallBack", 400.0, days);
		return ResponseEntity.ok(payment);
	}

}
