package bootcamp.microservicios.semanauno.accounts.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import bootcamp.microservicios.semanauno.commons.account.documents.Credits;

public interface CreditRepository extends ReactiveMongoRepository<Credits, String> {

}
