package bootcamp.microservicios.semanauno.clients.service;

import java.util.List;

import bootcamp.microservicios.semanauno.commons.microservicios.document.Account;
import bootcamp.microservicios.semanauno.commons.microservicios.document.Client;
//import bootcamp.microservicios.semanauno.commons.microservicios.document.Client;
import bootcamp.microservicios.semanauno.commons.microservicios.services.CommonService;
//import bootcamp.microservicios.semanauno.commons.clients.documents.Client;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ClientService extends CommonService<Client> {

	public Mono<Client> findById(String id);

	public Flux<Client> findAlls();

	public Mono<Client> findByIds(Long id);

	public Mono<Client> saves(Client entity);

	public Mono<Client> delete(Client entity);

    public Iterable<Client> saveAll(Iterable<Client> clients);

	public Flux<Client> findClientByAccount(String clienteId, String pasivoId);

	public Flux<Client> findClientByCredit(String clienteId, String activoId);

	public Client findClientByAccountId(Long id);

	public Iterable<Long> obtenerAccountIdsClients(Long alumnoId);

	public Iterable<Account> obtenerAccountPorClient(List<Long> ids);

	public void eliminarCursoAlumnoPorId(Long id);

}
