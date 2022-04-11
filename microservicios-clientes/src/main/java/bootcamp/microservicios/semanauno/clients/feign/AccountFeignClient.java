package bootcamp.microservicios.semanauno.clients.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import bootcamp.microservicios.semanauno.commons.microservicios.document.Account;

//import bootcamp.microservicios.semanauno.commons.account.documents.Account;

@FeignClient(name = "microservicio-cuentas")
public interface AccountFeignClient {

	@GetMapping("/pasivo-por-cliente/{id}")
	public Account obtenerClienteporCuentaPasivo(@PathVariable String id);

	@GetMapping("/activo-por-cliente/{id}")
	public Account obtenerClienteporCuentaActivo(@PathVariable String id);

}
