package bootcamp.microservicios.semanauno.accounts.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import bootcamp.microservicios.semanauno.commons.account.documents.Account;

public interface AccountRepository extends ReactiveMongoRepository<Account, String> {

}
