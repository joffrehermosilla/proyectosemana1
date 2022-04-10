package bootcamp.microservices.app.companyaccounts.services;

import java.util.Date;

import javax.validation.Validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bootcamp.microservices.app.companyaccounts.documents.CompanyAccount;
import bootcamp.microservices.app.companyaccounts.exceptions.customs.CustomNotFoundException;
import bootcamp.microservices.app.companyaccounts.repository.CompanyAccountRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
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
		return accountRepository.save(companyAccount);
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
