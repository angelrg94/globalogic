package cl.globalogic.bci.entities;

import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;


@Entity
@Table(name="PHONE")
public class Phone {
	
	@Id
	@GeneratedValue(generator="UUID")
	@GenericGenerator(
			name = "UUID",
			strategy = "org.hibernate.id.UUIDGenerator"
		)
	@Column(name = "phoneId", updatable = false, nullable = false)
	private UUID phoneId;
	private int number;
	private int cityCode;
	private int countryCode;
    @JsonProperty(value= "user", access=Access.WRITE_ONLY)	
	@ManyToOne(optional=false ,cascade = CascadeType.ALL)
	@JoinColumn(name="fk_userId",insertable=true)
	public User user;
	
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public UUID getPhoneId() {
		return phoneId;
	}
	public void setPhoneId(UUID phoneId) {
		this.phoneId = phoneId;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public int getCityCode() {
		return cityCode;
	}
	public void setCityCode(int cityCode) {
		this.cityCode = cityCode;
	}
	public int getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(int countryCode) {
		this.countryCode = countryCode;
	}
	
}
