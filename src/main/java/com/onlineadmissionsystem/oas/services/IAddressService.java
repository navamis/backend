package com.onlineadmissionsystem.oas.services;



import java.util.List;

import  com.onlineadmissionsystem.oas.entities.Address;

public interface IAddressService {
	
	public Address addAddress(Address address);
	
	public void deleteAddressById(int addressId);
	
	public Address updateAddress(Address add);
	
	public List<Address> getAddress();



	
	
	

}