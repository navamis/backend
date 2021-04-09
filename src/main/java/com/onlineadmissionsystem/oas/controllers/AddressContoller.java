package com.onlineadmissionsystem.oas.controllers;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.onlineadmissionsystem.oas.entities.Address;
import com.onlineadmissionsystem.oas.serviceimpl.AddressService;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;



@CrossOrigin("*")
@RestController

public class AddressContoller {
	
	static final Logger log=LoggerFactory.getLogger(AddressContoller.class);
	@Autowired
	AddressService addressservice;
	
	@PostMapping("/address/add")
	@ResponseStatus(code = HttpStatus.CREATED) 
	public Address addAddress(@RequestBody Address a) 
	{
		addressservice.addAddress(a);
		return a;
	}
	
	@DeleteMapping("/address/delete/{addressId}")
	@ResponseStatus(code = HttpStatus.OK) 
	public void deleteUser(@PathVariable("addressId") int addressId) 
	{
		addressservice.deleteAddressById(addressId); 
	}
	
	@PutMapping("/address/update/{addressId}")
	@ResponseStatus(code = HttpStatus.OK)
	@Transactional
	public Address updateAddress(@RequestBody Address address,@PathVariable("addressId") int addressId) {
		return addressservice.updateAddress(address);
	}
	
	@GetMapping("/address/get")
	@ResponseStatus(code = HttpStatus.OK)
	public ArrayList<Address> getAddressById() {
		return (ArrayList<Address>) addressservice.getAddress();
	}
}