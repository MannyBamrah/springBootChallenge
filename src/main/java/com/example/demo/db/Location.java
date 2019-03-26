package com.example.demo.db;

import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class Location{
	private String lat;
	@Field("long")
	private String longitude;
}