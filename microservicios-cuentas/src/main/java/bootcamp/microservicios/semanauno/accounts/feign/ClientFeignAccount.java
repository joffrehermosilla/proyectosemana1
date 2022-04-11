package bootcamp.microservicios.semanauno.accounts.feign;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "microservice-company-account-types")
public interface ClientFeignAccount {

}
