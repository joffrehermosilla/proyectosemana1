package bootcamp.microservicios.semanauno.commons.microservicios.document;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//import bootcamp.microservicios.semanauno.commons.clients.documents.Account;
import lombok.Data;

@Data
@Document(collection = "clientes")
public class Client {

	@Id
	private String id;

	private String pasivoId;

	private String activoId;

	private String texto;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createAt;

	@JsonIgnoreProperties(value = { "cuentas_pasivas_cliente" })
	private List<Account> pasivos;

	@JsonIgnoreProperties(value = { "cuentas_activas_cliente" })
	private List<Credits> activos;

	@Transient
	private Account pasivo;

	@Transient
	private Credits activo;

	public void prePersis() {
		this.createAt = new Date();
	}

	public Client() {
		this.pasivos = new ArrayList<>();
		this.activos = new ArrayList<>();
	}

	public void setPasivo(Client c) {
		// TODO Auto-generated method stub
		this.pasivo = c.pasivo;
	}

}
