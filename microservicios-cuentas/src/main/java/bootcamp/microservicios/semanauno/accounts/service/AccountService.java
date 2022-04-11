package bootcamp.microservicios.semanauno.accounts.service;


import bootcamp.microservicios.semanauno.commons.microservicios.document.Account;
//import bootcamp.microservicios.semanauno.commons.account.documents.Account;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface AccountService {

	public Flux<Account> findAll();

	public Mono<Account> findById(String id);

	public Mono<Account> save(Account account);

	public Mono<Void> delete(Account account);
	
	
	
	
}
