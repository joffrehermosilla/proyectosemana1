package bootcamp.microservices.app.accounts.documents;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
@Document
public class Account implements Serializable {

	private static final long serialVersionUID = -2192062026580323624L;

	private String id;

	private String accountNumber;

	private String idAccountType;

	private String idClient;

	private Double amount;

	@JsonFormat(pattern = "dd-MM-yyyy")
	private Date createDate;

	private String createUser;

	@JsonFormat(pattern = "dd-MM-yyyy")
	private Date modifyDate;

	private String modifyUser;
}
