package bootcamp.microservices.app.clients.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

<<<<<<< HEAD:proyectosemana1/microservice-clients/src/main/java/bootcamp/microservices/clients/app/repository/ClientRepository.java
import bootcamp.microservices.clients.app.documents.Client;
import reactor.core.publisher.Flux;
=======
import bootcamp.microservices.app.clients.documents.Client;
>>>>>>> d60c53bec1a4562ccdc60e789de1259f980828fc:microservice-clients/src/main/java/bootcamp/microservices/app/clients/repository/ClientRepository.java
import reactor.core.publisher.Mono;

public interface ClientRepository extends ReactiveMongoRepository<Client, String> {

	Flux<Client> findByDocumentNumber(String documentNumber);

//	Mono<Client> findByDocumentNumber(String document);
}
