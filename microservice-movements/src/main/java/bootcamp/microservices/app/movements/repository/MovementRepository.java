package bootcamp.microservices.app.movements.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import bootcamp.microservices.app.movements.documents.Movement;

public interface MovementRepository extends ReactiveMongoRepository<Movement, String>{

}
