package bootcamp.microservices.app.companyaccounts.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import bootcamp.microservices.app.companyaccounts.documents.CompanyAccount;
import reactor.core.publisher.Flux;

public interface CompanyAccountRepository extends ReactiveMongoRepository<CompanyAccount, String> {

}
