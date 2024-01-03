package com.codewithkarthik.repository;

import org.springframework.data.repository.CrudRepository;

import com.codewithkarthik.model.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Long>{

}
