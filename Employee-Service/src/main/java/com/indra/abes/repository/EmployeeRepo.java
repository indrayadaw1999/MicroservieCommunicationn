package com.indra.abes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.indra.abes.entity.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer> {

}
