package bootcamp.microservicios.semanauno.commons.clients.documents;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;



@Data
@Document(collection = "cliente_cuenta")
public class ClientAccount {
	@Id
	private String id;

	private String clientId;

	@JsonIgnoreProperties(value = "{accountClients}")
	private Client client;

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ClientAccount)) {
			return false;
		}

		ClientAccount a = (ClientAccount) obj;

		return this.clientId != null && this.clientId.equals(a.getClientId());
	}

}
