package bootcamp.microservices.app.companyaccounts.documents;

import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
@Document
public class CompanyAccount {

	private String id;

	private String accountNumber;

	private String idAccountType;

	private String idCompany;

	private Double amount;

	@JsonFormat(pattern = "dd-MM-yyyy")
	private Date createDate;

	private String createUser;

	@JsonFormat(pattern = "dd-MM-yyyy")
	private Date modifyDate;

	private String modifyUser;

}
