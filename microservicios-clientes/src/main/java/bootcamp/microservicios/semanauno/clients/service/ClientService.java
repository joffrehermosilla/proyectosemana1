package bootcamp.microservicios.semanauno.clients.service;


import bootcamp.microservicios.semanauno.commons.clients.documents.Client;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ClientService {

	public Flux<Client> findAll();

	public Mono<Client> findById(String id);

	public Mono<Client> save(Client client);

	public Mono<Void> delete(Client client);

//	public Iterable<Client> saveAll(Iterable<Client> clients);



}
