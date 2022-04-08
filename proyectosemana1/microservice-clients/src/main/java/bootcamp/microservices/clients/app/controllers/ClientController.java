package bootcamp.microservices.clients.app.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import bootcamp.microservices.clients.app.documents.Client;
import bootcamp.microservices.clients.app.exceptions.customs.CustomNotFoundException;
import bootcamp.microservices.clients.app.services.ClientService;
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
