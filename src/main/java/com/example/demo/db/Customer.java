package com.example.demo.db;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
@Document(collection="customers")
public class Customer{
	//@org.springframework.data.annotation.Id private String Id;
	private String firstName;
	private String lastName;
	private String mobile;
	private Address address;
	
	
}