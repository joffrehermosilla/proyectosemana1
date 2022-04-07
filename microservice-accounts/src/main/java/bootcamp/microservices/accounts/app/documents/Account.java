package bootcamp.microservices.accounts.app.documents;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Account {
	
	private String id;
	
	private String accountNumber;
	
	private int accountType;
	
	private String idClientCompany;
	
	private Double amount;
	
	@JsonFormat(pattern = "dd-MM-yyyy")	
	private Date createDate;
	
	private String createUser;
	
	@JsonFormat(pattern = "dd-MM-yyyy")	
	private Date modifyDate;
	
	private String modifyUser;
	

}
