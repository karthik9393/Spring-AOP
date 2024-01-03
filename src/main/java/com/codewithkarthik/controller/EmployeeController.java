package com.codewithkarthik.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.codewithkarthik.model.Employee;
import com.codewithkarthik.service.EmployeeService;

@RestController
@RequestMapping("api/v1")
public class EmployeeController {
	
	@Autowired
	private EmployeeService service;
	
	@GetMapping("/employees")
	public List<Employee> getall(){
		
		return service.getall();
		
	}
	
	@GetMapping("/employees/{id}")
	public ResponseEntity<Employee> getEmpById(@PathVariable Long  id){
		Employee employee = service.getEmployeeById(id).get();
		return ResponseEntity.ok().body(employee);
	}
	
	@PostMapping("/employees")
	public Employee addEmployee(@RequestBody Employee employee) {
		return service.addEmployee(employee);
		
	}
	
	@PutMapping("/employees/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable Long id,@RequestBody Employee emp) {
		Employee employee = service.updateEmployee(id, emp);
		return ResponseEntity.ok().body(employee);
		
	}
	@DeleteMapping("/employees/{id}")
	public ResponseEntity<String> deleteEmpById(@PathVariable Long id){
		service.deleteEmpById(id);
		return ResponseEntity.ok("Employee with Id "+ id + "deleted!!");
		
	}
	
	
	

}
