package bootcamp.microservicios.semanauno.clients.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import bootcamp.microservicios.semanauno.commons.clients.documents.Client;
import reactor.core.publisher.Flux;

public interface ClientRepository extends ReactiveMongoRepository<Client, String> {


}
