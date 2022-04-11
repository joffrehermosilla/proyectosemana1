package bootcamp.microservices.app.companyaccounts.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import bootcamp.microservices.app.companyaccounts.documents.CompanyAccountType;
import reactor.core.publisher.Mono;

@FeignClient(name = "microservice-company-account-types")
public interface CompanyAccountFeignTypeCompanyAccount {

	@GetMapping("/shortName/{shortName}")
	public Mono<CompanyAccountType> searchByShortName(@PathVariable String shortName);
}
