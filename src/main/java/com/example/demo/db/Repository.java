package com.example.demo.db;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface Repository extends MongoRepository<Customer,String>{
	List<Customer>findAll();
}
