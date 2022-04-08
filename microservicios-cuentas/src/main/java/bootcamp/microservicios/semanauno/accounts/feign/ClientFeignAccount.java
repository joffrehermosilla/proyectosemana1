package bootcamp.microservicios.semanauno.accounts.feign;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "microservicio-clientes")
public interface ClientFeignAccount {

}
