package bootcamp.microservices.app.companies.services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bootcamp.microservices.app.ccompanies.exceptions.customs.CustomNotFoundException;
import bootcamp.microservices.app.companies.documents.Company;
import bootcamp.microservices.app.companies.repository.CompanyRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CompanyServiceImpl implements CompanyService{

	@Autowired
	private CompanyRepository companyRepository;

	@Override
	public Flux<Company> findAll() {
		return companyRepository.findAll().switchIfEmpty(Mono.error(new CustomNotFoundException("Clients not exist")));
	}

	@Override
	public Mono<Company> findById(String id) {
		return companyRepository.findById(id)
				.switchIfEmpty(Mono.error(new CustomNotFoundException("Company not found")));
	}

	@Override
	public Mono<Company> update(Company company) {
		return companyRepository.findById(company.getId()).flatMap(c -> {
			c.setModifyUser(company.getModifyUser());
			c.setModifyDate(new Date());
			return companyRepository.save(c);
		}).switchIfEmpty(Mono.error(new CustomNotFoundException("Company not found")));
	}

	@Override
	public Mono<Company> save(Company company) {
		return companyRepository.findByDocumentNumber(company.getDocumentNumber())
				.switchIfEmpty(companyRepository.save(company));
	}

	@Override
	public Mono<Void> deleteNonLogic(Company company) {
		return companyRepository.findById(company.getId()).flatMap(c -> {
			return companyRepository.delete(c);
		}).switchIfEmpty(Mono.error(new CustomNotFoundException("Company not found")));
	}

	@Override
	public Mono<Company> deleteLogic(Company company) {
		return companyRepository.findById(company.getId()).flatMap(c -> {
			c.setModifyUser(company.getModifyUser());
			c.setModifyDate(new Date());
			return companyRepository.save(c);
		}).switchIfEmpty(Mono.error(new CustomNotFoundException("Company not found")));
	}

	@Override
	public Mono<Company> findByDocumentNumber(String document) {
		return companyRepository.findByDocumentNumber(document)
				.switchIfEmpty(Mono.error(new CustomNotFoundException("Company not found")));
	}
}
