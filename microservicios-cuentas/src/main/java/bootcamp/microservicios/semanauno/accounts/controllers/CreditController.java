package bootcamp.microservicios.semanauno.accounts.controllers;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import bootcamp.microservicios.semanauno.accounts.service.CreditService;
import bootcamp.microservicios.semanauno.commons.microservicios.document.Credits;
//import bootcamp.microservicios.semanauno.commons.account.documents.Credits;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@RestController
public class CreditController {

	private static final Logger LOGGER = LoggerFactory.getLogger(CreditController.class);

	@Autowired
	CreditService creditService;

	@GetMapping("/activo-all")
	public Flux<Credits> searchAll() {
		Flux<Credits> cli = creditService.findAll();
		LOGGER.info("Cuentas Activas: " + cli);
		return cli;
	}

	@GetMapping("/activo/id/{id}")
	public Mono<Credits> searchById(@PathVariable String id) {
		LOGGER.info("Cuenta Activa id: " + creditService.findById(id) + " con codigo: " + id);
		return creditService.findById(id);
	}

	@PostMapping("/crear-cuenta-activa")
	public Mono<Credits> createCredit(@Valid @RequestBody Credits activo) {
		LOGGER.info("Cuenta Activa creada: " + creditService.save(activo));
		return creditService.save(activo);
	}
}
