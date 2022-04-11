package bootcamp.microservicios.semanauno.accounts.documents;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


import bootcamp.microservicios.semanauno.commons.clients.documents.Client;
import lombok.Data;

//Estado de cuenta
@Data
@Document(collection = "cliente_cuenta_pasiva")
public class ClientAccount {
	@Id
	private String id;

	private String clientId;




	
	
	private String accountId;
	
	

}
