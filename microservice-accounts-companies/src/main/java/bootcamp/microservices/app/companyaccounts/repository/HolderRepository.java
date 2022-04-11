package bootcamp.microservices.app.companyaccounts.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import bootcamp.microservices.app.companyaccounts.documents.Holder;

public interface HolderRepository extends ReactiveMongoRepository<Holder, String>{

}
