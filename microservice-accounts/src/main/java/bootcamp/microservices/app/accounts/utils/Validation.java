package bootcamp.microservices.app.accounts.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bootcamp.microservices.app.accounts.services.AccountService;

@Component
public class Validation {

	@Autowired
	private AccountService service;

	public Boolean createAccountValidation(String idClient) {
		Boolean createAccount = false;
		Long accountQuaty = service.findByIdClient(idClient).block();
		if (accountQuaty == 0) {
			createAccount = true;
		}
		return createAccount;
	}
}
