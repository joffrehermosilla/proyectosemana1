package bootcamp.microservices.app.accounts.services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bootcamp.microservices.app.accounts.documents.Account;
import bootcamp.microservices.app.accounts.exceptions.customs.CustomNotFoundException;
import bootcamp.microservices.app.accounts.repository.AccountRepository;
import bootcamp.microservices.app.accounts.utils.Validation;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountRepository accountRepository;

	@Autowired
	private Validation validation;

	@Override
	public Flux<Account> findAll() {
		return accountRepository.findAll().switchIfEmpty(Mono.error(new CustomNotFoundException("Accounts not exist")));
	}

	@Override
	public Mono<Account> findById(String id) {
		return accountRepository.findById(id)
				.switchIfEmpty(Mono.error(new CustomNotFoundException("Account not found")));
	}

	@Override
	public Mono<Account> update(Account account) {
		return accountRepository.findById(account.getId()).flatMap(c -> {
			c.setModifyUser(account.getModifyUser());
			c.setModifyDate(new Date());
			return accountRepository.save(c);
		}).switchIfEmpty(Mono.error(new CustomNotFoundException("Account not found")));
	}

	@Override
	public Mono<Account> save(Account account) {
		Boolean authorize = validation.createAccountValidation(account.getIdClient());
		if (authorize == true) {
			return accountRepository.save(account);
		} else {
			return Mono.error(new CustomNotFoundException("Client can't have more than one account"));
		}
	}

	@Override
	public Mono<Void> deleteNonLogic(Account account) {
		return accountRepository.findById(account.getId()).flatMap(c -> {
			return accountRepository.delete(c);
		}).switchIfEmpty(Mono.error(new CustomNotFoundException("Account not found")));
	}

	@Override
	public Mono<Account> deleteLogic(Account account) {
		return accountRepository.findById(account.getId()).flatMap(c -> {
			c.setModifyUser(account.getModifyUser());
			c.setModifyDate(new Date());
			return accountRepository.save(c);
		}).switchIfEmpty(Mono.error(new CustomNotFoundException("Account not found")));
	}

	@Override
	public Mono<Long> findByIdClient(String idClient) {
		return accountRepository.findByIdClient(idClient).count();
	}

}
