package bootcamp.microservices.app.companyaccounts.services;

import bootcamp.microservices.app.companyaccounts.documents.CompanyAccount;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CompanyAccountService {

	public Flux<CompanyAccount> findAll();

	public Mono<CompanyAccount> findById(String id);

	public Mono<CompanyAccount> save(CompanyAccount account);

	public Mono<CompanyAccount> update(CompanyAccount account);

	public Mono<Void> deleteNonLogic(CompanyAccount account);

	public Mono<CompanyAccount> deleteLogic(CompanyAccount account);


}
