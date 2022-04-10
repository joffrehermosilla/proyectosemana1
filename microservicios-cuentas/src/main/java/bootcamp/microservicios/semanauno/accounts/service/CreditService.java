package bootcamp.microservicios.semanauno.accounts.service;

import bootcamp.microservicios.semanauno.commons.account.documents.Credits;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CreditService {
	public Flux<Credits> findAll();

	public Mono<Credits> findById(String id);

	public Mono<Credits> save(Credits account);

	public Mono<Void> delete(Credits account);
}
