package bootcamp.microservicios.semanauno.accounts.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import org.springframework.stereotype.Repository;

import bootcamp.microservicios.semanauno.commons.microservicios.document.Account;

//import bootcamp.microservicios.semanauno.commons.account.documents.Account;



@Repository
public interface AccountRepository extends ReactiveMongoRepository<Account, String> {

}
