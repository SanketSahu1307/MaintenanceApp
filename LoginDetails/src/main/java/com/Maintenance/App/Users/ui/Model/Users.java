package com.Maintenance.App.Users.ui.Model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.format.annotation.DateTimeFormat;




@Entity
@Table(name = "users")
public class Users {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NotBlank(message = "name is mandatory.")
	@Size(min=2,max=50)
	private String name;
	
	@NotBlank(message = "mobile number is mandatory.")
	@Size(min = 0,max = 10)
	private String mobileNumber;
	
	@NotBlank(message = "email is mandatory.")
	@Email(message = "Email should be valid.")
//	@Column(unique = true)
	private String email;
	
	
	@NotBlank(message = "password is mandatory.")
	private String password;
	
	@DateTimeFormat
	private Date dateOfCreate=new Date();
	
	public Users() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
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

	public Date getDateOfCreate() {
		return dateOfCreate;
	}

	public void setDateOfCreate(Date dateOfCreate) {
		this.dateOfCreate = dateOfCreate;
	}

	public Users(Long id, @NotNull(message = "name is mandatory.") @Size(min = 2, max = 50) String name,
			@NotNull(message = "mobile number is mandatory.") @Size(min = 0, max = 10) String mobileNumber,
			@NotNull(message = "email is mandatory.") @Email(message = "Email should be valid.") String email,
			@NotNull(message = "password is mandatory.") String password, Date dateOfCreate) {
		super();
		this.id = id;
		this.name = name;
		this.mobileNumber = mobileNumber;
		this.email = email;
		this.password = password;
		this.dateOfCreate = dateOfCreate;
	}

	@Override
	public String toString() {
		return String.format("Login [id=%s, name=%s, mobileNumber=%s, email=%s, password=%s, dateOfCreate=%s]", id,
				name, mobileNumber, email, password, dateOfCreate);
	}
	
	

}
