package bootcamp.microservicios.semanauno.clients.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bootcamp.microservicios.semanauno.clients.controllers.ClientController;
import bootcamp.microservicios.semanauno.clients.document.AccountClient;
import bootcamp.microservicios.semanauno.clients.feign.AccountFeignClient;
import bootcamp.microservicios.semanauno.clients.repository.ClientRepository;
import bootcamp.microservicios.semanauno.clients.service.ClientService;
import bootcamp.microservicios.semanauno.commons.microservicios.document.Account;
//import bootcamp.microservicios.semanauno.commons.account.documents.Account;
//import bootcamp.microservicios.semanauno.commons.clients.documents.Client;
import bootcamp.microservicios.semanauno.commons.microservicios.document.Client;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ClientServiceImpl implements ClientService {

	private static final Logger LOGGER = LoggerFactory.getLogger(ClientServiceImpl.class);
	@Autowired
	private ClientRepository clientRepository;

	@Autowired
	AccountFeignClient clienteCuenta;

	@Override
	public Flux<Client> findAll() {

		return clientRepository.findAll();
	}

	@Override
	public Mono<Client> findById(String id) {

		return clientRepository.findById(id);
	}

	@Override
	public Mono<Client> save(Client client) {

		return clientRepository.save(client);
	}

	@Override
	public Mono<Void> delete(Client client) {

		return clientRepository.delete(client);
	}

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

		List<Client> clientesporcuenta = (List<Client>) clientRepository.findClientByAccount(clienteId, clientsId);
		LOGGER.info("Colleccion de clientes de las cuentas:" + clientesporcuenta);
		// el map va a retornar un nuevo flujo con los datos cambiado para ser asignado
		// al cliente c
		clientesporcuenta = clientesporcuenta.stream().map(cpc -> {
			clients.forEach(c -> {
				if (c.getId() == cpc.getPasivoId())
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

}
