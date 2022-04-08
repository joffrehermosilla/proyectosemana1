package bootcamp.microservices.app.clients.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import bootcamp.microservices.app.clients.documents.Client;
import reactor.core.publisher.Mono;

public interface ClientRepository extends ReactiveMongoRepository<Client, String> {

	Mono<Client> findByDocumentNumber(String document);
}
