package bootcamp.microservices.app.companyaccounts.documents;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
@Document
public class CompanyAccount implements Serializable {

	private static final long serialVersionUID = -2539345833558909018L;

	private String id;

	private String accountNumber;

	private String idAccountType;

	private String idCompany;

	private Double amount;
	
	private List<Holder> listOfHolders;
	
	private List<Signatory> listOfSignatories;

	@JsonFormat(pattern = "dd-MM-yyyy")
	private Date createDate;

	private String createUser;

	@JsonFormat(pattern = "dd-MM-yyyy")
	private Date modifyDate;

	private String modifyUser;

}
