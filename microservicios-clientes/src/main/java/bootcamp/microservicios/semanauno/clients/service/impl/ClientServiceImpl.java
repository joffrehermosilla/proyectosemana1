package bootcamp.microservicios.semanauno.clients.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import bootcamp.microservicios.semanauno.clients.repository.ClientRepository;
import bootcamp.microservicios.semanauno.clients.service.ClientService;
import bootcamp.microservicios.semanauno.commons.clients.documents.Client;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ClientServiceImpl implements ClientService {

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
	public Mono<Client> save(Client client) {

		return clientRepository.save(client);
	}

	@Override
	public Mono<Void> delete(Client client) {

		return clientRepository.delete(client);
	}




}
