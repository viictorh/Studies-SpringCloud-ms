package br.com.vhb.hrpayroll.services;

import org.springframework.stereotype.Service;

import br.com.vhb.hrpayroll.entities.Payment;

//seria equivalente ao @Component, mas por questão de semantica usa-se @service
@Service
public class PaymentService {

	public Payment getPayment(long workerId, int days) {
		return new Payment("Bob", 200.0, days);
	}

}
