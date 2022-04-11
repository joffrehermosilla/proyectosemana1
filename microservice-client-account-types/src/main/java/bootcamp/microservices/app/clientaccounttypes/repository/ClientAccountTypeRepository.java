package bootcamp.microservices.app.clientaccounttypes.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import bootcamp.microservices.app.clientaccounttypes.documents.ClientAccountType;

public interface ClientAccountTypeRepository extends ReactiveMongoRepository<ClientAccountType, String> {

	public Flux<ClientAccountType> findByRegisterStatus();
	
	public Mono<ClientAccountType> findByShortNameAndStatus(String shortName, Integer status);
}
