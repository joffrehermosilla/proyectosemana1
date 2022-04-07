package bootcamp.microservices.clients.app.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import bootcamp.microservices.clients.app.documents.Company;
import reactor.core.publisher.Mono;

public interface CompanyRepository extends ReactiveMongoRepository<Company, String> {

	Mono<Company> findByDocumentNumber(String document);
}
