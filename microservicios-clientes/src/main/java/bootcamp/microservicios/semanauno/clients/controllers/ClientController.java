package bootcamp.microservicios.semanauno.clients.controllers;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import bootcamp.microservicios.semanauno.clients.service.ClientService;
import bootcamp.microservicios.semanauno.commons.microservicios.document.Client;
//import bootcamp.microservicios.semanauno.commons.account.documents.Account;
//import bootcamp.microservicios.semanauno.commons.clients.documents.Client;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class ClientController {

	private static final Logger LOGGER = LoggerFactory.getLogger(ClientController.class);

	@Autowired
	private ClientService clientService;

	/*
	 * @PostMapping("/crear-con-iterable") public ResponseEntity<?>
	 * crear(@RequestBody Iterable<Client> clients) {
	 * 
	 * clients = ((List<Client>) clients).stream().map(r -> {
	 * r.setCuentaId(r.getCuentaId());
	 * 
	 * return r; }).collect(Collectors.toList());
	 * 
	 * Iterable<Client> respuestasDb = clientService.saveAll(clients);
	 * 
	 * return ResponseEntity.status(HttpStatus.CREATED).body(respuestasDb);
	 * 
	 * }
	 */

	/*
	 * @PostMapping("/crear-con-reactor") public Mono<ResponseEntity<Map<String,
	 * Object>>> crearx(@Valid @RequestBody Mono<Client> monoCliente) { Map<String,
	 * Object> respuesta = new HashMap<String, Object>();
	 * 
	 * return monoCliente.flatMap(cliente -> { if (cliente.getCreateAt() == null) {
	 * cliente.setCreateAt(new Date()); } return clientService.save(cliente).map(p
	 * -> { respuesta.put("cliente", p); respuesta.put("mensaje",
	 * "cliente creado con exito con webflux"); respuesta.put("timestamp", new
	 * Date()); return
	 * ResponseEntity.created(URI.create("/api/clients/".concat(p.getId())))
	 * .contentType(MediaType.APPLICATION_JSON_UTF8).body(respuesta); });
	 * 
	 * });
	 * 
	 * }
	 */

	/*
	 * @GetMapping("/listar") public ResponseEntity<?> listar() {
	 * 
	 * List<Client> clientes = (clientService.findAll()).toStream().map(c -> {
	 * c.getClientAccount().forEach(ca -> { Account cuenta = new Account();
	 * cuenta.setId(ca.getClientId()); c.addAccounts(cuenta); }); return c;
	 * }).collect(Collectors.toList());
	 * 
	 * LOGGER.info("CLIENTES REGISTRADOS: " + clientes + " STATUS: " +
	 * ResponseEntity.ok().body(clientes));
	 * 
	 * return ResponseEntity.ok().body(clientes); }
	 */

	@GetMapping("/all")
	public Flux<Client> searchAll() {
		Flux<Client> cli = clientService.findAll();
		LOGGER.info("CLIENTES REGISTRADOS: " + cli);
		return cli;
	}

	@GetMapping("/id/{id}")
	public Mono<Client> searchById(@PathVariable String id) {
		LOGGER.info("CLIENTE id: " + clientService.findById(id) + " con codigo: " + id);
		return clientService.findById(id);
	}

	@PostMapping("/crear-cliente")
	public Mono<Client> createClient(@Valid @RequestBody Client client) {
		LOGGER.info("CLIENTE creado: " + clientService.save(client));
		return clientService.save(client);
	}

}
