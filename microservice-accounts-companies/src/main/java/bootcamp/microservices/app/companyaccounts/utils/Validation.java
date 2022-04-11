package bootcamp.microservices.app.companyaccounts.utils;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bootcamp.microservices.app.companyaccounts.documents.CompanyAccountType;
import bootcamp.microservices.app.companyaccounts.documents.Signatory;
import bootcamp.microservices.app.companyaccounts.feign.CompanyAccountFeignTypeCompanyAccount;
import reactor.core.publisher.Flux;
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

	public Boolean signatoryAccountValidatio(List<Signatory> list) {
		Boolean createAccount = false;
		if (list.size() > 0) {
			createAccount = true;
		}
		return createAccount;
	}
}
