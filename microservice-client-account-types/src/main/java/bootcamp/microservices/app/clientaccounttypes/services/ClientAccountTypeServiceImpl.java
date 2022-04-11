package bootcamp.microservices.app.clientaccounttypes.services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bootcamp.microservices.app.clientaccounttypes.constants.Constants;
import bootcamp.microservices.app.clientaccounttypes.documents.ClientAccountType;
import bootcamp.microservices.app.clientaccounttypes.exceptions.customs.CustomNotFoundException;
import bootcamp.microservices.app.clientaccounttypes.repository.ClientAccountTypeRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ClientAccountTypeServiceImpl implements ClientAccountTypeService {

	@Autowired
	private ClientAccountTypeRepository clientAccountTypeRepository;

	@Override
	public Flux<ClientAccountType> findAll() {
		return clientAccountTypeRepository.findAll()
				.switchIfEmpty(Mono.error(new CustomNotFoundException("Clients not exist")));
	}

	@Override
	public Mono<ClientAccountType> findById(String id) {
		return clientAccountTypeRepository.findById(id)
				.switchIfEmpty(Mono.error(new CustomNotFoundException("Client not found")));
	}

	@Override
	public Mono<ClientAccountType> update(ClientAccountType clientAccountType) {
		return clientAccountTypeRepository.findById(clientAccountType.getId()).flatMap(c -> {
			c.setModifyUser(clientAccountType.getModifyUser());
			c.setModifyDate(new Date());
			return clientAccountTypeRepository.save(c);
		}).switchIfEmpty(Mono.error(new CustomNotFoundException("Client not found")));
	}

	@Override
	public Mono<ClientAccountType> save(ClientAccountType cvlieAccountType) {
		return clientAccountTypeRepository.findByShortNameAndStatus(cvlieAccountType.getShortName(),Constants.ACTIVE)
				.switchIfEmpty(clientAccountTypeRepository.save(cvlieAccountType));
	}

	@Override
	public Mono<Void> deleteNonLogic(ClientAccountType clientAccountType) {
		return clientAccountTypeRepository.findById(clientAccountType.getId()).flatMap(c -> {
			return clientAccountTypeRepository.delete(c);
		}).switchIfEmpty(Mono.error(new CustomNotFoundException("Client not found")));
	}

	@Override
	public Mono<ClientAccountType> deleteLogic(ClientAccountType clientAccountType) {
		return clientAccountTypeRepository.findById(clientAccountType.getId()).flatMap(c -> {
			c.setModifyUser(clientAccountType.getModifyUser());
			c.setModifyDate(new Date());
			return clientAccountTypeRepository.save(c);
		}).switchIfEmpty(Mono.error(new CustomNotFoundException("Client not found")));
	}

}
