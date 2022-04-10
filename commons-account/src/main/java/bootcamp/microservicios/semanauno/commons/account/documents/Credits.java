package bootcamp.microservicios.semanauno.commons.account.documents;

import org.springframework.data.mongodb.core.mapping.Document;

/*import javax.validation.constraints.Max;
import javax.validation.constraints.Min;*/
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import lombok.Data;

@Data
@Document(collection = "activo")
public class Credits {

	@Id
	private String id;

	/*
	 * creditname el nombre del tipo credito: Personal, Empresarial y Tarjeta de
	 * Credito
	 */
	@Size(max = 20, min = 3, message = "{creditname.message.invalid}")
	@NotEmpty(message = "Please enter accountname Ahorro, Cuenta corriente or Plazo fijo")
	private String creditname;

	/*
	 * creditaccountcounter es un contador de el numero total de cuentas de credito
	 * por cliente Segun el enunciado hay restricciones para las cuentas
	 * 
	 * 
	 */

	@NotNull(message = " creditaccountcountero segun el enunciado del proyecto no null")
	private Long creditaccountcounter;

	/*
	 * authorizedsigner firmante autorizado [0] o titular[1]
	 * 
	 * 
	 * 
	 */

	@NotNull(message = "Please authorizedsigner")
	private Long authorizedsigner;
	
	
	

	private Credits(CreditBuilder builder) {
		this.id = builder.Id;
		this.creditname = builder.creditname;
		this.creditaccountcounter = builder.creditaccountcounter;
		this.authorizedsigner = builder.authorizedsigner;
	}

	public Credits() {
	
	}

	public static class CreditBuilder {

		private String Id;
		private String creditname;
		private Long creditaccountcounter;
		private Long authorizedsigner;

		public CreditBuilder(String creditname, Long creditaccountcounter, Long authorizedsigner) {
			this.creditname = creditname;
			this.creditaccountcounter = creditaccountcounter;
			this.authorizedsigner = authorizedsigner;
		}

		public CreditBuilder creditname(String creditname) {
			this.creditname = creditname;
			return this;
		}

		public CreditBuilder creditaccountcounter(Long creditaccountcounter) {
			this.creditaccountcounter = creditaccountcounter;
			return this;
		}

		public CreditBuilder authorizedsigner(Long authorizedsigner) {
			this.authorizedsigner = authorizedsigner;
			return this;
		}

	}

}
