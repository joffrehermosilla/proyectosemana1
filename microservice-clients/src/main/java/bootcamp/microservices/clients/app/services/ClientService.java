package bootcamp.microservices.clients.app.services;

import bootcamp.microservices.clients.app.documents.Client;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ClientService {

	public Flux<Client> findAll();

	public Mono<Client> findById(String id);

	public Mono<Client> save(Client client);

	public Mono<Client> update(Client client);

	public Mono<Void> deleteNonLogic(Client client);

	public Mono<Client> deleteLogic(Client client);

	Mono<Client> findByDocumentNumber(String document);

}