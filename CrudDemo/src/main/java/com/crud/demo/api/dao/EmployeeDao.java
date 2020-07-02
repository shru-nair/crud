package com.crud.demo.api.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crud.demo.api.model.Employee;

public interface EmployeeDao extends JpaRepository<Employee, Integer>{

	//void save(List<Employee> employees);
	List<Employee> findByName(String name);

}
