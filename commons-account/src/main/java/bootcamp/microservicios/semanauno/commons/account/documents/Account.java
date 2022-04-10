package bootcamp.microservicios.semanauno.commons.account.documents;

import javax.validation.constraints.NotEmpty;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "pasivo")
public class Account {

	@Id
	private String id;

	/*
	 * 
	 * accountname el nombre de la cuenta : Ahorro, Cuenta corriente y Plazo fijo
	 * según el enunciado del proyecto
	 * 
	 */

	@NotEmpty
	private String accountname;

	/*
	 * maintenancefee comision de mantenimiento segun el enunciado del proyecto
	 * 
	 * 
	 */
	@NotEmpty
	private Double maintenancefee;
	/*
	 * monthlymovement limite de movimientos mensuales segun el enunciado del
	 * proyecto
	 * 
	 * 
	 */
	@NotEmpty
	private Long monthlymovement;

	private Account(AccountBuilder builder) {

		this.id = builder.id;
		this.accountname = builder.accountname;
		this.maintenancefee = builder.maintenancefee;
		this.monthlymovement = builder.monthlymovement;
	}

	public Account() {

	}

	public static class AccountBuilder {

		private String id;
		private String accountname;

		private Double maintenancefee;
		private Long monthlymovement;

		public AccountBuilder(String accountname, Double maintenancefee, Long monthlymovement) {
			this.accountname = accountname;
			this.maintenancefee = maintenancefee;
			this.monthlymovement = monthlymovement;
		}

		public AccountBuilder accountname(String accountname) {
			this.accountname = accountname;
			return this;
		}

		public AccountBuilder maintenancefee(Double maintenancefee) {
			this.maintenancefee = maintenancefee;
			return this;
		}

		public AccountBuilder monthlymovement(Long monthlymovement) {
			this.monthlymovement = monthlymovement;
			return this;
		}

	}

}
