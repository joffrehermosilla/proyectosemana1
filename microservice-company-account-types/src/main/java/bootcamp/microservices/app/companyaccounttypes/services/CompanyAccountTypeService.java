package bootcamp.microservices.app.companyaccounttypes.services;

import bootcamp.microservices.app.companyaccounttypes.documents.CompanyAccountType;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CompanyAccountTypeService {

	public Flux<CompanyAccountType> findAll();

	public Mono<CompanyAccountType> findById(String id);

	public Mono<CompanyAccountType> save(CompanyAccountType companyAccountType);

	public Mono<CompanyAccountType> update(CompanyAccountType companyAccountType);

	public Mono<Void> deleteNonLogic(CompanyAccountType companyAccountType);

	public Mono<CompanyAccountType> deleteLogic(CompanyAccountType companyAccountType);

	public Mono<CompanyAccountType> findByShortNameAndStatus(String shortName);

}
