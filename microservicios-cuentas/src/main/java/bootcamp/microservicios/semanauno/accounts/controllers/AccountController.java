package bootcamp.microservicios.semanauno.accounts.controllers;

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

import bootcamp.microservicios.semanauno.accounts.service.AccountService;

import bootcamp.microservicios.semanauno.commons.account.documents.Account;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class AccountController {
	private static final Logger LOGGER = LoggerFactory.getLogger(AccountController.class);
	@Autowired
	AccountService accountService;

	/*
	 * @GetMapping("/listar") public ResponseEntity<?> listar() {
	 * 
	 * List<Account> clientes = (accountService.findAll()).toStream().map(c -> {
	 * c.getClientAccount().forEach(ca -> { Account pasivo = new Account();
	 * cuenta.setId(ca.getClientId()); c.addAccounts(pasivo); });
	 * 
	 * return c; }).collect(Collectors.toList());
	 * 
	 * return ResponseEntity.ok().body(clientes); }
	 */

	@GetMapping("/all")
	public Flux<Account> searchAll() {
		Flux<Account> cli = accountService.findAll();
		LOGGER.info("Cuentas Pasivas: " + cli);
		return cli;
	}

	@GetMapping("/id/{id}")
	public Mono<Account> searchById(@PathVariable String id) {

		LOGGER.info("Cuenta Pasiva id: " + accountService.findById(id) + " con codigo: " + id);
		return accountService.findById(id);
	}

	@PostMapping("/crear-cuenta-pasiva")
	public Mono<Account> createAccount(@Valid @RequestBody Account pasivo) {

		LOGGER.info("Cuenta Pasiva creada: " + accountService.save(pasivo));
		return accountService.save(pasivo);
	}

}
