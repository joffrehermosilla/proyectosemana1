package bootcamp.microservices.clients.app.services;

import org.springframework.beans.factory.annotation.Autowired;

import bootcamp.microservices.clients.app.documents.Client;
import bootcamp.microservices.clients.app.repository.ClientRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class ClientServiceImpl implements ClientService{

	@Autowired
	private ClientRepository clientRepository;

	@Override
	public Flux<Client> findAll() {
		return clientRepository.findAll();
	}

	@Override
	public Mono<Client> findById(String id) {
		return clientRepository.findById(id);
	}

	@Override
	public Mono<Client> save(Client Client) {
		return clientRepository.save(Client);
	}

	@Override
	public Mono<Void> delete(Client Client) {
		return clientRepository.delete(Client);
	}

}
