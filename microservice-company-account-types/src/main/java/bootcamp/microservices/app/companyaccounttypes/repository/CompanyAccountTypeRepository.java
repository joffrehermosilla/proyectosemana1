package bootcamp.microservices.app.companyaccounttypes.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import bootcamp.microservices.app.companyaccounttypes.documents.CompanyAccountType;
import reactor.core.publisher.Mono;

public interface CompanyAccountTypeRepository extends ReactiveMongoRepository<CompanyAccountType, String> {

	public Mono<CompanyAccountType> findByShortNameAndStatus(String shortName, Integer status);

}
