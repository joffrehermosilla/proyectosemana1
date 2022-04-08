package bootcamp.microservices.app.accounts.utils;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import bootcamp.microservices.app.accounts.documents.Account;
import bootcamp.microservices.app.accounts.services.AccountService;

public class Validation {

	@Autowired
	private AccountService service;

	public Boolean createAccountValidation(String idClient) {
		Boolean create = false;
		List<Account> lista = service.findByIdClient(idClient).collectList().block();
		if (lista.size() == 0) {
			create = true;
		} else {
			create = false;
		}
		return create;
	}

}
