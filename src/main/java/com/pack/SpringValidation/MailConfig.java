package com.pack.SpringValidation;

import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.validation.annotation.Validated;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Configuration
@PropertySource("classpath:mail.properties")
@ConfigurationProperties(prefix="mail")
@Data
@Validated
public class MailConfig {
	@NotNull
	private String to;
	@NotNull
	private String from;
	@Min(value=20)
	@Max(value=40)
	private Integer age;
	private String FIRSTNAME; // ConfigProp - Loosely bound
	private String Last_Name; // Loose Bound

	private String[] cc; // Complex props
	private List<String> bcc; // Complex properties

	@Valid
	private Credential credential = new Credential();
	
	@Data // To access get+set of nested properties
	public class Credential {
		@NotNull
		private String username; // nested prop
		@Size(max=8, min=4)
		private String password; // nested prop
	}	
}
