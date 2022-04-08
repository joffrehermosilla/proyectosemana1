package bootcamp.microservices.app.companies.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import bootcamp.microservices.app.companies.documents.Company;
import reactor.core.publisher.Mono;

public interface CompanyRepository extends ReactiveMongoRepository<Company, String> {

	Mono<Company> findByDocumentNumber(String document);
}

