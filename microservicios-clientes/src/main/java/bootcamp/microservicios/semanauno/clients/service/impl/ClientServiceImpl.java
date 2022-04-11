package bootcamp.microservicios.semanauno.clients.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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



	@Override
	public Flux<Client> findClientByAccount(String clienteId, Iterable<String> cuentasIds) {
		//relacionamos el document Account con la interface Feign
		Account account = clienteCuenta.obtenerClienteporCuentaPasivo(clienteId);
		
		
		List<AccountClient> client = account.getClient();
		List<String> cuentapasivasId = client.stream().map(p -> p.getId()).collect(Collectors.toList());
		
		List<Client> clientesporcuenta = (List<Client>) clientRepository.findClientByAccount(clienteId, cuentapasivasId);
		
		
		clientesporcuenta = clientesporcuenta.stream().map(cpc ->{
			client.forEach(c ->{
				if(c.getId()== cpc.getId())
					cpc.set
			});
		})
		
		return null;
	}

}
