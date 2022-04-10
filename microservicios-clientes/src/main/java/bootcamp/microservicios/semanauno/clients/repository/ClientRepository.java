package bootcamp.microservicios.semanauno.clients.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import bootcamp.microservicios.semanauno.commons.clients.documents.Client;


@Repository
public interface ClientRepository extends ReactiveMongoRepository<Client, String> {


}
