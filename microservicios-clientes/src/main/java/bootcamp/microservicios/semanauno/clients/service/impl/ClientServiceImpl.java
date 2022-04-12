package bootcamp.microservicios.semanauno.clients.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bootcamp.microservicios.semanauno.clients.feign.AccountFeignClient;
import bootcamp.microservicios.semanauno.clients.repository.ClientRepository;
import bootcamp.microservicios.semanauno.clients.service.ClientService;

import bootcamp.microservicios.semanauno.commons.microservicios.document.Account;

import bootcamp.microservicios.semanauno.commons.microservicios.document.Client;
import bootcamp.microservicios.semanauno.commons.microservicios.services.CommonServiceImpl;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ClientServiceImpl extends CommonServiceImpl<Client, ClientRepository> implements ClientService {

	private static final Logger LOGGER = LoggerFactory.getLogger(ClientServiceImpl.class);

	@Autowired
	AccountFeignClient clienteCuenta;

	// @SuppressWarnings("unchecked")
	@Override
	public Flux<Client> findClientByAccount(String clienteId, String pasivosIds) {
		// relacionamos el document Account con la interface Feign
		Account account = clienteCuenta.obtenerClienteporCuentaPasivo(clienteId);

		LOGGER.info("account proveniente del feign" + account);

		List<Client> clients = account.getPasivosporcliente();

		LOGGER.info("Lista de clientes con cuenta pasiva:" + clients);

		List<String> clientsId = clients.stream().map(c -> c.getId()).collect(Collectors.toList());

		LOGGER.info("Colleccion de Ids de las cuentas pasivas por client:" + clientsId);

		List<Client> clientesporcuenta = (List<Client>) repository.findClientByAccount(clienteId, clientsId);
		LOGGER.info("Colleccion de clientes de las cuentas:" + clientesporcuenta);
		// el map va a retornar un nuevo flujo con los datos cambiado para ser asignado
		// al cliente c
		clientesporcuenta = clientesporcuenta.stream().map(cpc -> {
			clients.forEach(c -> {
				if (c.getId() == cpc.getPasivoId())
					//generacion de relacion distribuida
					cpc.setPasivo(c);
			});
			LOGGER.info("Confirmar que es cpc:" + cpc);
			return cpc;
		}).collect(Collectors.toList());
		LOGGER.info("mostrar :" + clientesporcuenta);
		return (Flux<Client>) clientesporcuenta;
	}

	@Override
	public Flux<Client> findClientByCredit(String clienteId, String activoId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Client> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Client> findById(Long Id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Client save(Client entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public Mono<Client> saves(Client entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Flux<Client> findAlls() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Mono<Client> findByIds(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Client findClientByAccountId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Long> obtenerAccountIdsClients(Long alumnoId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Account> obtenerAccountPorClient(List<Long> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminarCursoAlumnoPorId(Long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public Mono<Client> delete(Client entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Mono<Client> findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Client> saveAll(Iterable<Client> clients) {
		// TODO Auto-generated method stub
		return (Iterable<Client>) repository.saveAll(clients);
	}

}
