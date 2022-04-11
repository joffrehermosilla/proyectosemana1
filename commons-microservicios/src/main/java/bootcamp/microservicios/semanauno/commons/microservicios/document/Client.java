package bootcamp.microservicios.semanauno.commons.microservicios.document;

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

	private Long cuentaId;

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

	public Long getCuentaId() {
		return cuentaId;
	}

	public void setCuentaId(Long cuentaId) {
		this.cuentaId = cuentaId;
	}

	public Date getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
