package bootcamp.microservices.app.clients.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import bootcamp.microservices.app.clients.documents.Client;
import bootcamp.microservices.app.clients.services.ClientService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class ClientController {

	@Autowired
	private ClientService service;


	@PostMapping
	public Mono<Client> createClient(@Valid @RequestBody Client client) {
		return service.save(client);
	}

	@GetMapping("/all")
	public Flux<Client> searchAll() {
		return service.findAll();
	}

	@GetMapping("/id/{id}")
	public Mono<Client> searchById(@PathVariable String id) {
		return service.findById(id);
	}
	
	@GetMapping("/documentNumber/{documentNumber}")
	public Mono<Client> searchByDocument(@PathVariable String documentNumber) {
		return service.findByDocumentNumber(documentNumber);
	}


}
