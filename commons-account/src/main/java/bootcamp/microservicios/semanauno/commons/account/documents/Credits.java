package bootcamp.microservicios.semanauno.commons.account.documents;

import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotEmpty;

import org.springframework.data.annotation.Id;
import lombok.Data;

@Data
@Document(collection = "activo")
public class Credits {

	@Id
	private String Id;

	/*
	 * creditname el nombre del tipo credito: Personal, Empresarial y Tarjeta de
	 * Credito
	 */
	@NotEmpty
	private String creditname;

	/*
	 * creditaccountcounter es un contador de el numero total de cuentas de credito
	 * por cliente Segun el enunciado hay restricciones para las cuentas
	 * 
	 * 
	 */
	@NotEmpty
	private Long creditaccountcounter;

	/*
	 * authorizedsigner firmante autorizado [0] o titular[1]
	 * 
	 * 
	 * 
	 */
	@NotEmpty
	private Long authorizedsigner;

	private Credits(CredittBuilder builder) {
		this.Id = builder.Id;
		this.creditname = builder.creditname;
		this.creditaccountcounter = builder.creditaccountcounter;
		this.authorizedsigner = builder.authorizedsigner;
	}

	public static class CredittBuilder {

		private String Id;
		private String creditname;
		private Long creditaccountcounter;
		private Long authorizedsigner;

		public CredittBuilder(String creditname, Long creditaccountcounter, Long authorizedsigner) {
			this.creditname = creditname;
			this.creditaccountcounter = creditaccountcounter;
			this.authorizedsigner = authorizedsigner;
		}

		public CredittBuilder creditname(String creditname) {
			this.creditname = creditname;
			return this;
		}

		public CredittBuilder creditaccountcounter(Long creditaccountcounter) {
			this.creditaccountcounter = creditaccountcounter;
			return this;
		}

		public CredittBuilder authorizedsigner(Long authorizedsigner) {
			this.authorizedsigner = authorizedsigner;
			return this;
		}

	}

	public void setId(String id) {
		Id = id;
	}

	public void setCreditname(String creditname) {
		this.creditname = creditname;
	}

	public void setCreditaccountcounter(Long creditaccountcounter) {
		this.creditaccountcounter = creditaccountcounter;
	}

	public void setAuthorizedsigner(Long authorizedsigner) {
		this.authorizedsigner = authorizedsigner;
	}

}
