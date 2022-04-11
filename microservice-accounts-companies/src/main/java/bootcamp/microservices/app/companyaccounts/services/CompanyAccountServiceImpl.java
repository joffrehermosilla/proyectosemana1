package bootcamp.microservices.app.companyaccounts.services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import bootcamp.microservices.app.companyaccounts.documents.CompanyAccount;
import bootcamp.microservices.app.companyaccounts.exceptions.customs.CustomNotFoundException;
import bootcamp.microservices.app.companyaccounts.repository.CompanyAccountRepository;
import bootcamp.microservices.app.companyaccounts.utils.Validation;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@Transactional
public class CompanyAccountServiceImpl implements CompanyAccountService {

	@Autowired
	private CompanyAccountRepository accountRepository;

	@Autowired
	private Validation validation;

	@Override
	public Flux<CompanyAccount> findAll() {
		return accountRepository.findAll().switchIfEmpty(Mono.error(new CustomNotFoundException("Accounts not exist")));
	}

	@Override
	public Mono<CompanyAccount> findById(String id) {
		return accountRepository.findById(id)
				.switchIfEmpty(Mono.error(new CustomNotFoundException("CompanyAccount not found")));
	}

	@Override
	public Mono<CompanyAccount> update(CompanyAccount companyAccount) {
		return accountRepository.findById(companyAccount.getId()).flatMap(c -> {
			c.setModifyUser(companyAccount.getModifyUser());
			c.setModifyDate(new Date());
			return accountRepository.save(c);
		}).switchIfEmpty(Mono.error(new CustomNotFoundException("CompanyAccount not found")));
	}

	@Override
	public Mono<CompanyAccount> save(CompanyAccount companyAccount) {
		Boolean authorize = validation.createAccountValidation(companyAccount.getIdAccountType());
		Boolean haveSignatory = validation.signatoryAccountValidatio(companyAccount.getListOfSignatories());
		if (authorize == true && haveSignatory == true) {
			return accountRepository.save(companyAccount);
		} else {
			return Mono.error(new CustomNotFoundException(
					"Companies only can open account companies and must have almost one signatory"));
		}
	}

	@Override
	public Mono<Void> deleteNonLogic(CompanyAccount companyAccount) {
		return accountRepository.findById(companyAccount.getId()).flatMap(c -> {
			return accountRepository.delete(c);
		}).switchIfEmpty(Mono.error(new CustomNotFoundException("CompanyAccount not found")));
	}

	@Override
	public Mono<CompanyAccount> deleteLogic(CompanyAccount companyAccount) {
		return accountRepository.findById(companyAccount.getId()).flatMap(c -> {
			c.setModifyUser(companyAccount.getModifyUser());
			c.setModifyDate(new Date());
			return accountRepository.save(c);
		}).switchIfEmpty(Mono.error(new CustomNotFoundException("CompanyAccount not found")));
	}

}
