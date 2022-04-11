package bootcamp.microservicios.semanauno.accounts.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import bootcamp.microservicios.semanauno.commons.microservicios.document.Credits;

//import bootcamp.microservicios.semanauno.commons.account.documents.Credits;

@Repository
public interface CreditRepository extends ReactiveMongoRepository<Credits, String> {

}
