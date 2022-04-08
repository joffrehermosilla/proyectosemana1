package bootcamp.microservicios.semanauno.clients.controllers;

import java.net.URI;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.support.WebExchangeBindException;

import bootcamp.microservicios.semanauno.clients.service.ClientService;
import bootcamp.microservicios.semanauno.commons.account.documents.Account;
import bootcamp.microservicios.semanauno.commons.clients.documents.Client;
import lombok.Data;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class ClientController {

	@Autowired
	private ClientService clientService;

	@PostMapping
	public ResponseEntity<?> crear(@RequestBody Iterable<Client> clients) {

		clients = ((List<Client>) clients).stream().map(r -> {
			r.setCuentaId(r.getCuentaId());

			return r;
		}).collect(Collectors.toList());

		Iterable<Client> respuestasDb = clientService.saveAll(clients);

		return ResponseEntity.status(HttpStatus.CREATED).body(respuestasDb);

	}

	@PostMapping
	public Mono<ResponseEntity<Map<String, Object>>> crearx(@Valid @RequestBody Mono<Client> monoCliente) {
		Map<String, Object> respuesta = new HashMap<String, Object>();

		return monoCliente.flatMap(cliente -> {
			if (cliente.getCreateAt() == null) {
				cliente.setCreateAt(new Date());
			}
			return clientService.save(cliente).map(p -> {
				respuesta.put("cliente", p);
				respuesta.put("mensaje", "cliente creado con exito con webflux");
				respuesta.put("timestamp", new Date());
				return ResponseEntity.created(URI.create("/api/clients/".concat(p.getId())))
						.contentType(MediaType.APPLICATION_JSON_UTF8).body(respuesta);
			});

		});

	}

	@GetMapping
	public ResponseEntity<?> listar() {

		List<Client> clientes = (clientService.findAll()).toStream().map(c -> {
			c.getClientAccount().forEach(ca -> {
				Account cuenta = new Account();
				cuenta.setId(ca.getClientId());
				c.addAccounts(cuenta);
			});
			return c;
		}).collect(Collectors.toList());

		return ResponseEntity.ok().body(clientes);
	}

}
