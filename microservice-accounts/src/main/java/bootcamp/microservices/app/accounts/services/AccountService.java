package bootcamp.microservices.app.accounts.services;

import bootcamp.microservices.app.accounts.documents.Account;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface AccountService {

	public Flux<Account> findAll();

	public Mono<Account> findById(String id);

	public Mono<Account> save(Account account);

	public Mono<Account> update(Account account);

	public Mono<Void> deleteNonLogic(Account account);

	public Mono<Account> deleteLogic(Account account);

	public Mono<Long> findByIdClient(String idClient);
}
