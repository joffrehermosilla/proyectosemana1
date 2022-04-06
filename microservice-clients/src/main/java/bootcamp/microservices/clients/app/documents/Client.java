package bootcamp.microservices.clients.app.documents;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document
public class Client implements Serializable {
	
	private static final long serialVersionUID = -1116153273782136818L;

	private String id;
	
	private String documentNumber;
	
	private String name;
	
	private String lastName;
	
	private Integer age;
	
	private String idTypeClient;
	
	private Date createDate;
	
	private String createUser;
	
	private Date modifyDate;
	
	private String modifyUser;
		
}
