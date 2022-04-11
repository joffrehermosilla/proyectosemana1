package bootcamp.microservices.app.companyaccounts.feign;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "microservicio-clientes")
public class CompanyAccountFeignTypeCompanyAccount {

}
