package com.business.ems.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.business.ems.models.Employee;
import com.business.ems.repositories.EmployeeRepository;

@Service
public class EmployeeService {
	private final EmployeeRepository employeeRepository;
	public EmployeeService(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}
	public Iterable<Employee> allEmployees() {
		return employeeRepository.findAll();
	}
	public Employee findEmployee(Long id) {
		Optional<Employee> optionalEmployee = employeeRepository.findById(id);
		if (optionalEmployee.isPresent()) {
			return optionalEmployee.get();
		}
		else {
			return null;
		}
	}
	public Employee createEmployee(Employee e) {
		return employeeRepository.save(e);
	}
	
}
