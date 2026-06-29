package com.jbdl.wallet.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserCreateRequest {

	private String name;
	
	@Email
	@NotBlank
	private String email;
	
	@NotBlank
	private String contact;
	
	
	public User to() {
		return User.builder().name(this.name).email(this.email).contact(this.contact).build();
	}
	
	
	
	
	
}
