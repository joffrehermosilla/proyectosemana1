package bootcamp.microservicios.semanauno.accounts.documents;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import bootcamp.microservicios.semanauno.commons.clients.documents.Client;
import lombok.Data;

@Data
@Document(collection = "cliente_cuenta_activa")
public class ClientCredit {

	@Id
	private String id;
	
	private String clientId;
	
	@JsonIgnoreProperties(value = "{creditClients}")
	private Client client;
	
	private String creditId;
	
	
	
}
