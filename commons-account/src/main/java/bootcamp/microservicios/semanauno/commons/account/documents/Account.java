package bootcamp.microservicios.semanauno.commons.account.documents;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "cuentas")
public class Account {

	@Id
	private String id;

	private String accountname;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
}
