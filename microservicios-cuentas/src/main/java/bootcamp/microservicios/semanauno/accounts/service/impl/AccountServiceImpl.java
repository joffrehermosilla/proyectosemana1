package bootcamp.microservicios.semanauno.accounts.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bootcamp.microservicios.semanauno.accounts.repository.AccountRepository;
import bootcamp.microservicios.semanauno.accounts.service.AccountService;
import bootcamp.microservicios.semanauno.commons.microservicios.document.Account;
//import bootcamp.microservicios.semanauno.commons.account.documents.Account;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	AccountRepository accounRepository;
	

	
	@Override
	public Flux<Account> findAll() {

		return accounRepository.findAll();
	}

	@Override
	public Mono<Account> findById(String id) {
	
		return accounRepository.findById(id);
	}

	@Override
	public Mono<Account> save(Account account) {

		return accounRepository.save(account);
	}

	@Override
	public Mono<Void> delete(Account account) {

		return accounRepository.delete(account);
	}

}
