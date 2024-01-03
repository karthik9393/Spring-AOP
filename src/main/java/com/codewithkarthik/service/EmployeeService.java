package com.codewithkarthik.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.codewithkarthik.model.Employee;
import com.codewithkarthik.repository.EmployeeRepository;

import jakarta.persistence.EntityNotFoundException;

public class EmployeeService {
	
	@Autowired
	private EmployeeRepository repo;

	public List<Employee> getall() {
		
		return (List<Employee>) repo.findAll();
	}

	public Optional<Employee> getEmployeeById(Long id) {
		
		return repo.findById(id);
	}

	public Employee addEmployee(Employee employee) {
		
		return repo.save(employee);
	}

	public Employee updateEmployee(Long id, Employee emp) {
		Optional<Employee> existingOne = repo.findById(id);
		if(existingOne.isPresent()) {
			Employee update = existingOne.get();
			update.setFirstName(emp.getFirstName());
			update.setLastName(emp.getLastName());
			update.setEmailId(emp.getEmailId());
			
			return repo.save(update);
		}else {
			throw new EntityNotFoundException("Employee with ID "+ id + "not found");
		}
		
	}

	public void deleteEmpById(Long id) {
		
		repo.deleteById(id);
		
	}

	
		
		
	

}
