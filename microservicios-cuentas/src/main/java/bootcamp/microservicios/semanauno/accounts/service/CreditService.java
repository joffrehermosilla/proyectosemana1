package bootcamp.microservicios.semanauno.accounts.service;

import bootcamp.microservicios.semanauno.commons.microservicios.document.Credits;
//import bootcamp.microservicios.semanauno.commons.account.documents.Credits;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CreditService {
	public Flux<Credits> findAll();

	public Mono<Credits> findById(String id);

	public Mono<Credits> save(Credits credit);

	public Mono<Void> delete(Credits credit);
}
