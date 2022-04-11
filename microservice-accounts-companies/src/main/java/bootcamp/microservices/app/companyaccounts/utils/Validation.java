package bootcamp.microservices.app.companyaccounts.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bootcamp.microservices.app.companyaccounts.documents.CompanyAccountType;
import bootcamp.microservices.app.companyaccounts.feign.CompanyAccountFeignTypeCompanyAccount;
import reactor.core.publisher.Mono;

@Component
public class Validation {

	@Autowired
	private CompanyAccountFeignTypeCompanyAccount service;

	public Boolean createAccountValidation(String shortName) {
		Boolean createAccount = false;
		Mono<CompanyAccountType> accountType = service.searchByShortName(shortName);
		if (!accountType.blockOptional().isEmpty()) {
			createAccount = true;
		}
		return createAccount;
	}
}
