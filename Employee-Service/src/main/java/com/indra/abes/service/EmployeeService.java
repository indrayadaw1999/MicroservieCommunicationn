package com.indra.abes.service;

import java.util.Optional;

import org.apache.catalina.mapper.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.modelmapper.ModelMapper;

import com.indra.abes.entity.Employee;
import com.indra.abes.repository.EmployeeRepo;
import com.indra.abes.response.AddressResponse;
import com.indra.abes.response.EmployeeResponse;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepo employeeRepo;
	
	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	public RestTemplate restTemplate;
	
	
	public EmployeeResponse getEmployeeById(int id)
	{
		Optional<Employee> employee = employeeRepo.findById(id);
		
		EmployeeResponse employeeResponse = mapper.map(employee, EmployeeResponse.class);
		
		AddressResponse addressResponse = restTemplate.getForObject("http://localhost:8081/address-service/address/{id}", AddressResponse.class, id);
		
		employeeResponse.setAddressResponse(addressResponse);
		
		return employeeResponse;
		
	}
	
	
}
