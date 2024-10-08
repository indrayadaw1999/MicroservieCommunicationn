package com.indra.abes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.indra.abes.response.AddressResponse;
import com.indra.abes.service.AddressService;

@RestController
public class AddressController {

	@Autowired
	private AddressService addressService;
	
	@GetMapping("address/{employeeId}")
	public ResponseEntity<AddressResponse> getAddressByEmployeeId(@PathVariable("employeeId") int employeeId )
	{
		AddressResponse addressResponse = addressService.findAddressByEmployeeId(employeeId);
		
		return ResponseEntity.status(HttpStatus.OK).body(addressResponse);
	}
	
}
