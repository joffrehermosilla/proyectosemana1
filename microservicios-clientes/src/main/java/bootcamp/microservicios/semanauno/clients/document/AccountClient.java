package bootcamp.microservicios.semanauno.clients.document;

import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import bootcamp.microservicios.semanauno.commons.account.documents.Account;
import bootcamp.microservicios.semanauno.commons.clients.documents.Client;
import lombok.Data;

@Data
@Document(collection = "cuenta_por_cliente")
public class AccountClient {
	@Transient
	private Client client;
	@Transient
	private Account account;
	
	
}
