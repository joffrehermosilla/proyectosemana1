package bootcamp.microservices.app.companyaccounttypes.services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bootcamp.microservices.app.companyaccounttypes.constants.Constants;
import bootcamp.microservices.app.companyaccounttypes.documents.CompanyAccountType;
import bootcamp.microservices.app.companyaccounttypes.exceptions.customs.CustomNotFoundException;
import bootcamp.microservices.app.companyaccounttypes.repository.CompanyAccountTypeRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CompanyAccountTypeServiceImpl implements CompanyAccountTypeService {

	@Autowired
	private CompanyAccountTypeRepository companyAccountTypeRepository;

	@Override
	public Flux<CompanyAccountType> findAll() {
		return companyAccountTypeRepository.findAll()
				.switchIfEmpty(Mono.error(new CustomNotFoundException("Clients not exist")));
	}

	@Override
	public Mono<CompanyAccountType> findById(String id) {
		return companyAccountTypeRepository.findById(id)
				.switchIfEmpty(Mono.error(new CustomNotFoundException("Client not found")));
	}

	@Override
	public Mono<CompanyAccountType> update(CompanyAccountType companyAccountType) {
		return companyAccountTypeRepository.findById(companyAccountType.getId()).flatMap(c -> {
			c.setModifyUser(companyAccountType.getModifyUser());
			c.setModifyDate(new Date());
			return companyAccountTypeRepository.save(c);
		}).switchIfEmpty(Mono.error(new CustomNotFoundException("Client not found")));
	}

	@Override
	public Mono<CompanyAccountType> save(CompanyAccountType companyAccountType) {
		return companyAccountTypeRepository.findByShortNameAndStatus(companyAccountType.getShortName(),Constants.ACTIVE)
				.switchIfEmpty(companyAccountTypeRepository.save(companyAccountType));
	}

	@Override
	public Mono<Void> deleteNonLogic(CompanyAccountType companyAccountType) {
		return companyAccountTypeRepository.findById(companyAccountType.getId()).flatMap(c -> {
			return companyAccountTypeRepository.delete(c);
		}).switchIfEmpty(Mono.error(new CustomNotFoundException("Client not found")));
	}

	@Override
	public Mono<CompanyAccountType> deleteLogic(CompanyAccountType companyAccountType) {
		return companyAccountTypeRepository.findById(companyAccountType.getId()).flatMap(c -> {
			c.setModifyUser(companyAccountType.getModifyUser());
			c.setModifyDate(new Date());
			return companyAccountTypeRepository.save(c);
		}).switchIfEmpty(Mono.error(new CustomNotFoundException("Client not found")));
	}

	@Override
	public Mono<CompanyAccountType> findByShortNameAndStatus(String shortName) {
		return companyAccountTypeRepository.findByShortNameAndStatus(shortName, Constants.ACTIVE);
	}

}
