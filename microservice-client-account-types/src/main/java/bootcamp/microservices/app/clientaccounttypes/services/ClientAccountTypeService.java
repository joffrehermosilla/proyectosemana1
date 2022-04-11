package bootcamp.microservices.app.clientaccounttypes.services;

import bootcamp.microservices.app.clientaccounttypes.documents.ClientAccountType;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ClientAccountTypeService {

	public Flux<ClientAccountType> findAll();

	public Mono<ClientAccountType> findById(String id);

	public Mono<ClientAccountType> save(ClientAccountType clientAccountType);

	public Mono<ClientAccountType> update(ClientAccountType clientAccountType);

	public Mono<Void> deleteNonLogic(ClientAccountType clientAccountType);

	public Mono<ClientAccountType> deleteLogic(ClientAccountType clientAccountType);

}
