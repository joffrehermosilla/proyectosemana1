package bootcamp.microservices.clients.app.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import bootcamp.microservices.clients.app.documents.Client;

public interface ClientRepository  extends ReactiveMongoRepository<Client,String>{

}
