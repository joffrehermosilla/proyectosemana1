package bootcamp.microservices.app.companyaccounts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MicroserviceAccountsCompaniesApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceAccountsCompaniesApplication.class, args);
	}

}
