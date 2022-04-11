package bootcamp.microservices.app.companyaccounts.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface SignatoryRepository extends ReactiveMongoRepository<SignatoryRepository, String> {

}
