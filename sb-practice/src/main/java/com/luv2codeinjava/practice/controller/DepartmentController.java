package com.luv2codeinjava.practice.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.luv2codeinjava.practice.entity.Department;
import com.luv2codeinjava.practice.service.DepartmentService;

@RestController
public class DepartmentController {
	
	private final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);

	@Autowired
	private DepartmentService deptService;
	
	@PostMapping("/departments")
	public Department saveDepartment(@Valid @RequestBody Department department) {
		LOGGER.info("Inside saveDepartment of DepartmentController");
		Department dept = deptService.saveDept(department);
		return dept;
	}
	
	@GetMapping("/departments")	
	public List<Department> fetchDepartmentList() {
		LOGGER.info("Inside fetchDepartmentList of DepartmentController");
		return deptService.fetchDepartmentList();
		
	}
	
	@GetMapping("/departments/{id}")
	public Department fetchDepartmentById(@PathVariable("id") Long deptId) {
		return deptService.fetchDepartmentById(deptId);
	}
	
	@DeleteMapping("/departments/{id}")
	public String deleteDepartmentById(@PathVariable("id") Long deptId) {
		deptService.deleteDepartmentById(deptId);
		return "Department deleted successfully";
		
	}
	
	
	@PutMapping("/departments/{id}")
	public Department updatDepartment(@PathVariable("id") Long deptId, @RequestBody Department dept) {
		return deptService.updatDepartment(deptId, dept);
	}
	
	@GetMapping("/departments/name/{name}")
	public Department fetchDepartmentByName(@PathVariable("name") String deptName) {
		return deptService.fetchDepartmentByName(deptName);
	}
	
}
