package bootcamp.microservices.clients.app.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import bootcamp.microservices.clients.app.documents.Client;
import reactor.core.publisher.Mono;

public interface ClientRepository extends ReactiveMongoRepository<Client, String> {

	Mono<Client> findByDocumentNumber(String document);
}
