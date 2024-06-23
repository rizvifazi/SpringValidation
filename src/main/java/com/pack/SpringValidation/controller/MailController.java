package com.pack.SpringValidation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pack.SpringValidation.MailConfig;

@RestController
public class MailController {

	@Autowired
	MailConfig config;
	
	@GetMapping(value="/mail")
	public String getMail() {
		return config.getFIRSTNAME()+" "+config.getBcc()+" "+config.getCredential().getPassword();
	}
}
