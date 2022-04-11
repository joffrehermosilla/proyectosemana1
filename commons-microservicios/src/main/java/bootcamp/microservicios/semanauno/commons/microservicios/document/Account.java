package bootcamp.microservicios.semanauno.commons.microservicios.document;


import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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

	@Size(max = 20, min = 3, message = "{accountname.message.invalid}")
	@NotEmpty(message = "Please enter accountname Ahorro, Cuenta corriente or Plazo fijo")
	private String accountname;

	/*
	 * maintenancefee comision de mantenimiento segun el enunciado del proyecto
	 * 
	 * 
	 */

	@NotNull(message = " comision de mantenimiento segun el enunciado del proyecto no null")
	private Double maintenancefee;
	/*
	 * monthlymovement limite de movimientos mensuales segun el enunciado del
	 * proyecto
	 * 
	 * 
	 */

	@NotNull(message = " comision de mantenimiento segun el enunciado del proyecto no null")
	private Long monthlymovement;

	
	@Transient
	private Client clientporpasivo;
	
	@JsonIgnoreProperties(value = { "clientes_con_cuenta_pasiva" })
	private List<Client> pasivosporcliente;
	
	
	
	
	
	
	
	private Account(AccountBuilder builder) {

		this.id = builder.id;
		this.accountname = builder.accountname;
		this.maintenancefee = builder.maintenancefee;
		this.monthlymovement = builder.monthlymovement;
	}

	public Account() {
		this.pasivosporcliente =new ArrayList<>();
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
