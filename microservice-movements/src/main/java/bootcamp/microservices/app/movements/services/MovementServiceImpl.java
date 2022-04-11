package bootcamp.microservices.app.movements.services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bootcamp.microservices.app.movements.constants.Constants;
import bootcamp.microservices.app.movements.documents.Movement;
import bootcamp.microservices.app.movements.exceptions.customs.CustomNotFoundException;
import bootcamp.microservices.app.movements.repository.MovementRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class MovementServiceImpl implements MovementService {

	@Autowired
	private MovementRepository movementRepository;

	@Override
	public Flux<Movement> findAll() {
		return movementRepository.findAll().switchIfEmpty(Mono.error(new CustomNotFoundException("Clients not exist")));
	}

	@Override
	public Mono<Movement> findById(String id) {
		return movementRepository.findById(id)
				.switchIfEmpty(Mono.error(new CustomNotFoundException("Client not found")));
	}

	@Override
	public Mono<Movement> update(Movement movement) {
		return movementRepository.findById(movement.getId()).flatMap(c -> {
			c.setModifyUser(movement.getModifyUser());
			c.setModifyDate(new Date());
			return movementRepository.save(c);
		}).switchIfEmpty(Mono.error(new CustomNotFoundException("Client not found")));
	}

	@Override
	public Mono<Movement> save(Movement movement) {
		return movementRepository.save(movement);
	}

	@Override
	public Mono<Void> deleteNonLogic(Movement movement) {
		return movementRepository.findById(movement.getId()).flatMap(c -> {
			return movementRepository.delete(c);
		}).switchIfEmpty(Mono.error(new CustomNotFoundException("Client not found")));
	}

	@Override
	public Mono<Movement> deleteLogic(Movement movement) {
		return movementRepository.findById(movement.getId()).flatMap(c -> {
			c.setModifyUser(movement.getModifyUser());
			c.setModifyDate(new Date());
			c.setStatus(Constants.INACTIVE);
			return movementRepository.save(c);
		}).switchIfEmpty(Mono.error(new CustomNotFoundException("Client not found")));
	}
}
