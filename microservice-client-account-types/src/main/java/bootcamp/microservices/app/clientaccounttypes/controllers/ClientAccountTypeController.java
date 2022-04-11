package bootcamp.microservices.app.clientaccounttypes.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import bootcamp.microservices.app.clientaccounttypes.documents.ClientAccountType;
import bootcamp.microservices.app.clientaccounttypes.services.ClientAccountTypeService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class ClientAccountTypeController {

	@Autowired
	private ClientAccountTypeService service;

	@PostMapping
	public Mono<ClientAccountType> createClient(@Valid @RequestBody ClientAccountType clientAccountType) {
		return service.save(clientAccountType);
	}

	@GetMapping("/all")
	public Flux<ClientAccountType> searchAll() {
		return service.findAll();
	}

	@GetMapping("/id/{id}")
	public Mono<ClientAccountType> searchById(@PathVariable String id) {
		return service.findById(id);
	}

}
