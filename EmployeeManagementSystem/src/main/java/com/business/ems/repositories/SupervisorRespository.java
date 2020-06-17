package com.business.ems.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.business.ems.models.Supervisor;

@Repository
public interface SupervisorRespository extends CrudRepository<Supervisor, Long> {

}
