package com.luv2codeinjava.practice.service;

import java.util.List;

import com.luv2codeinjava.practice.entity.Department;

public interface DepartmentService {

	public Department saveDept(Department department);

	public List<Department> fetchDepartmentList();

	public Department fetchDepartmentById(Long deptId);

	public void deleteDepartmentById(Long deptId);

	public Department updatDepartment(Long deptId, Department dept);

	public Department fetchDepartmentByName(String deptName);

}
