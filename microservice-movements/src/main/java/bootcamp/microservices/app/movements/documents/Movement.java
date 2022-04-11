package bootcamp.microservices.app.movements.documents;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
@Document
public class Movement implements Serializable {

	private static final long serialVersionUID = -7264405121088013360L;

	private String id;

	private String idAccount;

	private Integer typeMovement;

	private String operationType;

	private Double amountOperation;

	private String operationDate;

	@JsonFormat(pattern = "dd-MM-yyyy")
	private Date createDate;

	private String createUser;

	@JsonFormat(pattern = "dd-MM-yyyy")
	private Date modifyDate;

	private String modifyUser;
	
	private Integer status;

}
