package bootcamp.microservicios.semanauno.accounts.documents;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "cuentas")
public class Account {

	@Id
	private String id;

	private String accountname;
}
