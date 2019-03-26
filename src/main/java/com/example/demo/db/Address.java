package com.example.demo.db;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class Address{
	private AddressInfo billing;
	private AddressInfo shipping;
}