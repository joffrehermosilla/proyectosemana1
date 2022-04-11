package bootcamp.microservices.app.movements.services;

import bootcamp.microservices.app.movements.documents.Movement;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface MovementService {

	public Flux<Movement> findAll();

	public Mono<Movement> findById(String id);

	public Mono<Movement> save(Movement movement);

	public Mono<Movement> update(Movement movement);

	public Mono<Void> deleteNonLogic(Movement movement);

	public Mono<Movement> deleteLogic(Movement movement);
}
