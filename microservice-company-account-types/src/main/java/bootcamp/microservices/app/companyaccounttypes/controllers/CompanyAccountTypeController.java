package bootcamp.microservices.app.companyaccounttypes.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import bootcamp.microservices.app.companyaccounttypes.documents.CompanyAccountType;
import bootcamp.microservices.app.companyaccounttypes.services.CompanyAccountTypeService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class CompanyAccountTypeController {

	@Autowired
	private CompanyAccountTypeService service;

	@PostMapping
	public Mono<CompanyAccountType> createClient(@Valid @RequestBody CompanyAccountType companyAccountType) {
		return service.save(companyAccountType);
	}

	@GetMapping("/all")
	public Flux<CompanyAccountType> searchAll() {
		return service.findAll();
	}

	@GetMapping("/id/{id}")
	public Mono<CompanyAccountType> searchById(@PathVariable String id) {
		return service.findById(id);
	}

	@GetMapping("/shortName/{shortName}")
	public Mono<CompanyAccountType> searchByShortName(@PathVariable String shortName) {
		return service.findByShortNameAndStatus(shortName);
	}

}
