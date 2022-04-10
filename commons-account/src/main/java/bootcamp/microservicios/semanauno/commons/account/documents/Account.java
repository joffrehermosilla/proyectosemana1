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
<<<<<<< Updated upstream
	 * accountname el nombre de la cuenta : Ahorro, Cuenta corriente y Plazo fijo
	 * según el enunciado del proyecto
	 * 
	 */

	@NotEmpty
=======
	 * accountname el nombre del tipo cuenta bancaria : Ahorro, Cuenta Corriente y
	 * Plazo fijo
	 */
>>>>>>> Stashed changes
	private String accountname;
	/*
	 * comisionmantenimiento el enunciado indica una comision por las cuentas segun
	 * cliente
	 * 
	 */
	private Double comisionmantenimiento;
	/*
	 * limitemaxmovimientos el enunciado indica una limite maximo de movimientos
	 * mensual segun cliente
	 * 
	 */
	private Long limitemaxmovimientos;

<<<<<<< Updated upstream
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
	
	
	
	

	public Account() {

	}

	private Account(AccountBuilder builder) {

		this.id = builder.id;
		this.accountname = builder.accountname;
		this.maintenancefee = builder.maintenancefee;
		this.monthlymovement = builder.monthlymovement;
	}

=======
	private Account(AccountBuilder builder) {
		this.id = builder.id;
		this.accountname = builder.accountname;
		this.comisionmantenimiento = builder.comisionmantenimiento;
		this.limitemaxmovimientos = builder.limitemaxmovimientos;
	}

	public Account() {

	}

>>>>>>> Stashed changes
	public static class AccountBuilder {

		private String id;
		private String accountname;
<<<<<<< Updated upstream
		private Double maintenancefee;
		private Long monthlymovement;

		public AccountBuilder(String accountname, Double maintenancefee, Long monthlymovement) {
			this.accountname = accountname;
			this.maintenancefee = maintenancefee;
			this.monthlymovement = monthlymovement;
		}
		
=======
		private Double comisionmantenimiento;
		private Long limitemaxmovimientos;

		public AccountBuilder(String accountname, Double comisionmantenimiento, Long limitemaxmovimientos) {
			this.accountname = accountname;
			this.comisionmantenimiento = comisionmantenimiento;
			this.limitemaxmovimientos = limitemaxmovimientos;
		}

>>>>>>> Stashed changes
		public AccountBuilder accountname(String accountname) {
			this.accountname = accountname;
			return this;
		}

<<<<<<< Updated upstream
		public AccountBuilder maintenancefee(Double maintenancefee) {
			this.maintenancefee = maintenancefee;
			return this;
		}

		public AccountBuilder monthlymovement(Long monthlymovement) {
			this.monthlymovement = monthlymovement;
			return this;
		}
		
		

	}
	
	
	
	
	
=======
		public AccountBuilder comisionmantenimiento(Double comisionmantenimiento) {
			this.comisionmantenimiento = comisionmantenimiento;
			return this;
		}

		public AccountBuilder limitemaxmovimientos(Long limitemaxmovimientos) {
			this.limitemaxmovimientos = limitemaxmovimientos;
			return this;
		}

	}
>>>>>>> Stashed changes

}
