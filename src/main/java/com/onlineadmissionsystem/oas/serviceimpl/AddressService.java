package com.onlineadmissionsystem.oas.serviceimpl;


import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.onlineadmissionsystem.oas.entities.Address;
import com.onlineadmissionsystem.oas.exceptions.AddressAlreadyExistsException;
import com.onlineadmissionsystem.oas.exceptions.AddressNotFoundException;
import com.onlineadmissionsystem.oas.repo.IAddressRepository;
import com.onlineadmissionsystem.oas.services.IAddressService;


@Service
public class AddressService implements IAddressService{
	static final Logger log=LoggerFactory.getLogger(AddressService.class);
	
	@Autowired
	IAddressRepository addrepo;

	@Override
	public Address addAddress(Address address) {
		Optional<Address> add=addrepo.findByAddressId(address.getAddressId());
		if(add.isPresent()) {
			throw new AddressAlreadyExistsException("Address Already Exists");
		}
		else {
		addrepo.save(address);
		return address;
	}
	}
	
	
	@Override
	public void deleteAddressById(int addressId) 
	{
		 Optional<Address> add = addrepo.findByAddressId(addressId);
         
	        if(add.isPresent()) 
	        {
	            addrepo.deleteById(addressId);
	        } else {
	            throw new AddressNotFoundException("No employee record exist for given id");
	        }
	        
	    } 
		
	

	@Override
	@Transactional
	public Address updateAddress(Address add) {
		  {
			  Address add1=null;
		        Optional<Address> address = addrepo.findByAddressId(add.getAddressId());
		        {
		        if(address.isPresent())
		        {
		        	
		        add1=address.get();
		       add1.setCity(add.getCity());
		       add1.setStates(add.getStates());
		       add1.setZipcode(add.getZipcode());
		       
		         
		        } 
		return add1;
		        }
		       
		  }
		  }

	@Override
	public List<Address> getAddress() {
		
		return addrepo.findAll();
		
	}
}