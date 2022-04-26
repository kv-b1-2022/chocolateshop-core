package in.chocoapp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "chocousers")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name = "username", nullable = false)
	private String name;
	@Column(name = "usermobile", nullable = false, unique = true)
	private String mobile;
	@Column(name = "useremail", nullable = false, unique = true)
	private String email;
	@Column(name = "useraddress", nullable = false)
	private String address;
	@Column(name = "userpassword", nullable = false)
	private String password;

}
