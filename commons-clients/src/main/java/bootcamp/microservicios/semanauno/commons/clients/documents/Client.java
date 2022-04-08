package bootcamp.microservicios.semanauno.commons.clients.documents;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import bootcamp.microservicios.semanauno.commons.account.documents.Account;
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

	@Transient
	private List<Account> accounts;

	public void prePersis() {
		this.createAt = new Date();
	}

	@JsonIgnoreProperties(value = { "cuentas" })
	private List<ClientAccount> clientAccount;

	public Long getCuentaId() {
		return cuentaId;
	}

	public void setCuentaId(Long cuentaId) {
		this.cuentaId = cuentaId;
	}

	public List<ClientAccount> getClientAccount() {
		return clientAccount;
	}

	public void setClientAccount(List<ClientAccount> clientAccount) {
		this.clientAccount = clientAccount;
	}

	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}

	public void addAccounts(Account account) {
		this.accounts.add(account);
	}

	public void removeAccounts(Account account) {
		this.accounts.remove(account);
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
