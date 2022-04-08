package bootcamp.microservices.app.clients.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import reactor.core.publisher.Mono;
import bootcamp.microservices.app.clients.documents.Client;

public interface ClientRepository extends ReactiveMongoRepository<Client, String> {

	Mono<Client> findByDocumentNumber(String documentNumber);

}
