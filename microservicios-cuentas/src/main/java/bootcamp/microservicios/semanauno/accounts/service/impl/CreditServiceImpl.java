package bootcamp.microservicios.semanauno.accounts.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bootcamp.microservicios.semanauno.accounts.repository.CreditRepository;
import bootcamp.microservicios.semanauno.accounts.service.CreditService;
import bootcamp.microservicios.semanauno.commons.account.documents.Credits;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CreditServiceImpl implements CreditService {

	@Autowired
	CreditRepository creditRepository;

	@Override
	public Flux<Credits> findAll() {

		return creditRepository.findAll();
	}

	@Override
	public Mono<Credits> findById(String id) {

		return creditRepository.findById(id);
	}

	@Override
	public Mono<Credits> save(Credits account) {

		return creditRepository.save(account);
	}

	@Override
	public Mono<Void> delete(Credits account) {

		return creditRepository.delete(account);
	}

}
