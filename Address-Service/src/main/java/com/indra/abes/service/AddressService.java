package com.indra.abes.service;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.indra.abes.entity.Address;
import com.indra.abes.repository.AddressRepo;
import com.indra.abes.response.AddressResponse;

@Service
public class AddressService {

	@Autowired
	private AddressRepo addressRepo;
	
	@Autowired
	private ModelMapper mapper;
	
	public AddressResponse findAddressByEmployeeId(int employeeId )
	{
		Optional<Address> addressByEmployeeId = addressRepo.findAddressByEmployeeId(employeeId);
		AddressResponse addressResponse = mapper.map(addressByEmployeeId, AddressResponse.class);
		
		return addressResponse;
		
	}
}
