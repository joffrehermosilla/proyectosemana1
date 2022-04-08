package bootcamp.microservices.clients.app.documents;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
@Document
public class Company implements Serializable {
	
	private static final long serialVersionUID = -1116153273782136818L;

	private String id;
	
	private String documentNumber;
	
	private String companyName;
		
	private Integer address;
	
	private String phoneNumber;
		
	@JsonFormat(pattern = "dd-MM-yyyy")	
	private Date createDate;
	
	private String createUser;
	
	@JsonFormat(pattern = "dd-MM-yyyy")	
	private Date modifyDate;
	
	private String modifyUser;

	public String getDocumentNumber() {
		return documentNumber;
	}

	public void setDocumentNumber(String documentNumber) {
		this.documentNumber = documentNumber;
	}
		
	
	
}
