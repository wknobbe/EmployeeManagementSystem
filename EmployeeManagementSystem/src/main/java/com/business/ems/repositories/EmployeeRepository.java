package com.business.ems.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.business.ems.models.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {

}
