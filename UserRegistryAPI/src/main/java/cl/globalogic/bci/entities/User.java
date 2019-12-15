package cl.globalogic.bci.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;


@Entity
@Table(name="USER")
public class User {

	@Id
	@GeneratedValue(generator="UUID")
	@GenericGenerator(
			name = "UUID",
			strategy = "org.hibernate.id.UUIDGenerator"
		)
	@Column(name = "id", updatable = false, nullable = false)
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String id;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Date creationDate;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Date modified;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Date lastLogin;
	private String username;
    @Pattern(regexp ="^(.+)@(.+)$",message="El correo no tiene el formato correcto")
	private String email;
    @JsonProperty(value= "password", access=Access.WRITE_ONLY)	
    @Pattern(regexp ="((?=.*\\d{2})(?=.*[a-z])(?=.*[A-Z])(^[a-zA-Z0-9]{1,}$))" , message="La clave no tiene el formato correcto")
	private String password;
    @JsonProperty(value= "phones", access=Access.WRITE_ONLY)	
	@OneToMany(mappedBy="user",cascade = CascadeType.ALL)
	private List<Phone> phones = new ArrayList<Phone>();
	private String token;
	private boolean isActive;
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public List<Phone> getPhones() {
		return phones;
	}
	public void setPhones(List<Phone> phones) {
		this.phones = phones;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	public Date getModified() {
		return modified;
	}
	public void setModified(Date modified) {
		this.modified = modified;
	}
	public Date getLastLogin() {
		return lastLogin;
	}
	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}
	


}
