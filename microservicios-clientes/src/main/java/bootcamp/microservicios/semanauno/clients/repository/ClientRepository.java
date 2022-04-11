package bootcamp.microservicios.semanauno.clients.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import bootcamp.microservicios.semanauno.clients.service.ClientService;
import bootcamp.microservicios.semanauno.commons.microservicios.document.Client;
//import bootcamp.microservicios.semanauno.commons.clients.documents.Client;
import reactor.core.publisher.Flux;

@Repository
public interface ClientRepository extends ReactiveMongoRepository<Client, String>,ClientService{
	   public Flux<Client> findClientByAccount(String clienteId, Iterable<String> cuentasIds);
}
