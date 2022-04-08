package bootcamp.microservices.app.companies.services;

import bootcamp.microservices.app.companies.documents.Company;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CompanyService {

	public Flux<Company> findAll();

	public Mono<Company> findById(String id);

	public Mono<Company> save(Company company);

	public Mono<Company> update(Company company);

	public Mono<Void> deleteNonLogic(Company company);

	public Mono<Company> deleteLogic(Company company);

	Mono<Company> findByDocumentNumber(String document);

}
