package bootcamp.microservicios.semanauno.clients.feign;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "microservicio-cuentas")
public interface AccountFeignClient {

}
