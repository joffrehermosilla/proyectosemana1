package bootcamp.microservices.app.companyaccounts.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bootcamp.microservices.app.companyaccounts.repository.CompanyAccountRepository;


@Component
public class Validation {

	@Autowired
	private CompanyAccountRepository accountRepository;

	public Boolean createAccountValidation(String idClient) {
		Boolean createAccount = false;
		Long accountQuaty = accountRepository.findByIdClient(idClient).block();
		if (accountQuaty == 0) {
			createAccount = true;
		}
		return createAccount;
	}
}
