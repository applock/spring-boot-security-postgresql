package com.security.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Formula;

@Entity
@Table(name = "users", uniqueConstraints = { @UniqueConstraint(columnNames = "username"),
		@UniqueConstraint(columnNames = "id") })
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	@Size(max = 50)
	private String username;

	@NotBlank
	@Size(max = 50)
	@Email
	private String email;

	@NotBlank
	@Size(min = 10, max = 10)
	@Pattern(regexp = "^\\d{10}$", message = "Must be a valid 10 digit mobile number")
	private String mobile;

	@NotBlank
	@Size(max = 250)
	private String password;

	//@ManyToMany(fetch = FetchType.LAZY)
	//@JoinTable(name = "authorities_users", foreignKey = @ForeignKey(name = "fk_authorities_users"), joinColumns = @JoinColumn(name = "username"), inverseJoinColumns = @JoinColumn(name = "authority"))
	//private Set<Authority> roles = new HashSet<>();
	
	//@OneToOne(mappedBy = "authorities", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	//@OneToOne(cascade = CascadeType.ALL)
    //@JoinColumn(name = "authorities_username", referencedColumnName = "username")
	//@Formula("(select * from authorities o where o.username = id)")
	//private Set<Authority> roles = new HashSet<>();

	public User() {
	}

	public User(String username, String email, String mobile, String password) {
		this.username = username;
		this.email = email;
		this.mobile = mobile;
		this.password = password;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

	/*
	 * public Set<Authority> getRoles() { return roles; }
	 * 
	 * public void setRoles(Set<Authority> roles) { this.roles = roles; }
	 */
	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

}
