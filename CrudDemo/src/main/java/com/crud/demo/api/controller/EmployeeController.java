package com.crud.demo.api.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.crud.demo.api.dao.EmployeeDao;
import com.crud.demo.api.model.Employee;

@RestController
public class EmployeeController {
	@Autowired
	private EmployeeDao employeedao;
			 
	 @PostMapping("/register")
	    public String register(@RequestBody Employee employee) {
		 employeedao.save(employee);
	        return " your Registration process successfully completed";
	    }
	    
	    @GetMapping("/getAllEmployee")
	    public List<Employee> findAllUsers() {
	        return employeedao.findAll();
	    }

	    @GetMapping("/findEmployee/{name}")
	    public List<Employee> findEmployee(@PathVariable String name) {
	        return employeedao.findByName(name);
	    }

	    @DeleteMapping("/cancel/{id}")
	    public List<Employee> cancelRegistration(@PathVariable int id) {
	    	employeedao.deleteById(id);
	        return employeedao.findAll();
	    }
}
