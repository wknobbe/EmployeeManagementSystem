package com.business.ems.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.business.ems.models.Department;

@Repository
public interface DepartmentRespository extends CrudRepository<Department, Long> {
	
}
