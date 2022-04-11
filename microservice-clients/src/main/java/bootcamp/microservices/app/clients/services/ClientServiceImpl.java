package bootcamp.microservices.app.clients.services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bootcamp.microservices.app.clients.documents.Client;
import bootcamp.microservices.app.clients.exceptions.customs.CustomNotFoundException;
import bootcamp.microservices.app.clients.repository.ClientRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ClientServiceImpl implements ClientService {

	@Autowired
	private ClientRepository clientRepository;

	@Override
	public Flux<Client> findAll() {
		return clientRepository.findAll().switchIfEmpty(Mono.error(new CustomNotFoundException("Clients not exist")));
	}

	@Override
	public Mono<Client> findById(String id) {
		return clientRepository.findById(id).switchIfEmpty(Mono.error(new CustomNotFoundException("Client not found")));
	}

	@Override
	public Mono<Client> update(Client client) {
		return clientRepository.findById(client.getId()).flatMap(c -> {
			c.setModifyUser(client.getModifyUser());
			c.setModifyDate(new Date());
			return clientRepository.save(c);
		}).switchIfEmpty(Mono.error(new CustomNotFoundException("Client not found")));
	}

	@Override
	public Mono<Client> save(Client client) {
		return clientRepository.findByDocumentNumber(client.getDocumentNumber())
				.switchIfEmpty(clientRepository.save(client));
	}

	@Override
	public Mono<Void> deleteNonLogic(Client client) {
		return clientRepository.findById(client.getId()).flatMap(c -> {
			return clientRepository.delete(c);
		}).switchIfEmpty(Mono.error(new CustomNotFoundException("Client not found")));
	}

	@Override
	public Mono<Client> deleteLogic(Client client) {
		return clientRepository.findByDocumentNumber(client.getDocumentNumber()).flatMap(c -> {
			c.setModifyUser(client.getModifyUser());
			c.setModifyDate(new Date());
			return clientRepository.save(c);
		}).switchIfEmpty(Mono.error(new CustomNotFoundException("Client not found")));
	}

	@Override
	public Mono<Client> findByDocumentNumber(String document) {
		return clientRepository.findByDocumentNumber(document)
				.switchIfEmpty(Mono.error(new CustomNotFoundException("Client not found")));
	}

}
