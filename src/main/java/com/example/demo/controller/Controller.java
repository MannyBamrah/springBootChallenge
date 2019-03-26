package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.db.Address;
import com.example.demo.db.AddressInfo;
import com.example.demo.db.Customer;
import com.example.demo.db.Location;
import com.example.demo.db.Repository;

@RestController
public class Controller{
	@Autowired
	private Repository repo;
	@RequestMapping("/customer")
	public ResponseEntity<?> getDetails(@RequestBody Customer request) {
		List<Customer> ResponseCust = new ArrayList<Customer>();
		try {
			List<Customer> custInfo = repo.findAll();
		for(Customer c : custInfo) {
			Customer customer = new Customer();
			if(!StringUtils.isEmpty(request.getFirstName())&&(request.getFirstName().equals("true"))) {
				customer.setFirstName(c.getFirstName());
			}
			if (!StringUtils.isEmpty(request.getLastName())&&(request.getLastName().equals("true"))) {
				customer.setLastName(c.getLastName());
			}
			if(!StringUtils.isEmpty(request.getAddress())) {
				Address a = new Address();
				if(!StringUtils.isEmpty(request.getAddress().getBilling())) {
					AddressInfo b = new AddressInfo();
					Location l = new Location();
					if(!StringUtils.isEmpty(request.getAddress().getBilling().getAddress())) {
						b.setAddress(c.getAddress().getBilling().getAddress());
						if(!StringUtils.isEmpty(request.getAddress().getBilling().getLocation())) {
							if(!StringUtils.isEmpty(request.getAddress().getBilling().getLocation().getLat())&&(request.getAddress().getBilling().getLocation().getLat().equals("true"))) {
								l.setLat(c.getAddress().getBilling().getLocation().getLat());
							}
							if(!StringUtils.isEmpty(request.getAddress().getBilling().getLocation().getLongitude())&&(request.getAddress().getBilling().getLocation().getLongitude().equals("true"))) {
								l.setLongitude(c.getAddress().getBilling().getLocation().getLongitude());
							}
							b.setLocation(l);
						}
						a.setBilling(b);
					}
				}
				if(!StringUtils.isEmpty(request.getAddress().getShipping())) {
					AddressInfo b = new AddressInfo();
					Location l = new Location();
					if(!StringUtils.isEmpty(request.getAddress().getShipping().getAddress())) {
						b.setAddress(c.getAddress().getShipping().getAddress());
						if(!StringUtils.isEmpty(request.getAddress().getShipping().getLocation())) {
							if(!StringUtils.isEmpty(request.getAddress().getShipping().getLocation().getLat())&&(request.getAddress().getShipping().getLocation().getLat().equals("true")))
								l.setLat(c.getAddress().getShipping().getLocation().getLat());
							if(!StringUtils.isEmpty(request.getAddress().getShipping().getLocation().getLongitude())&&(request.getAddress().getShipping().getLocation().getLongitude().equals("true")))
								l.setLongitude(c.getAddress().getShipping().getLocation().getLongitude());
							b.setLocation(l);
						}
						
						a.setShipping(b);
					}
			}
				customer.setAddress(a);
			}
			if(!StringUtils.isEmpty(request.getMobile())&& request.getMobile().equals("true")) {
				customer.setMobile(c.getMobile());
				
			}
			ResponseCust.add(customer);
		}
		}
		catch(Exception e) {
			
		}
		
		return ResponseEntity.ok(ResponseCust);
	}
}