package com.security.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "authorities")
public class Authority {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotBlank
	@Size(max = 50)
	private String username;

	@Enumerated(EnumType.STRING)
	@Column(length = 20)
	private ERole authority;

	public Authority() {

	}

	public Authority(ERole authority) {
		this.authority = authority;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public ERole getAuthority() {
		return authority;
	}

	public void setAuthority(ERole authority) {
		this.authority = authority;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}