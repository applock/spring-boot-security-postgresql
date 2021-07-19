package com.security.payload.request;

import java.util.Set;

import javax.validation.constraints.*;

import com.security.models.ERole;

public class SignupRequest {
	@NotBlank
	@Size(min = 5, max = 50)
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
	private ERole role;

	@NotBlank
	@Size(min = 6, max = 40)
	private String password;

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

	public ERole getRole() {
		return this.role;
	}

	public void setRole(ERole role) {
		this.role = role;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

}
