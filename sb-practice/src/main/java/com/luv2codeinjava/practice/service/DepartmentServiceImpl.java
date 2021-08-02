package com.luv2codeinjava.practice.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luv2codeinjava.practice.entity.Department;
import com.luv2codeinjava.practice.repository.DepartmentRepo;

@Service
public class DepartmentServiceImpl implements DepartmentService{

	@Autowired
	private DepartmentRepo deptRepo;
	
	@Override
	public Department saveDept(Department department) {
		return deptRepo.save(department);
	}

	@Override
	public List<Department> fetchDepartmentList() {
		return deptRepo.findAll();
	}

	@Override
	public Department fetchDepartmentById(Long deptId) {
		return deptRepo.findById(deptId).get();
	}

	@Override
	public void deleteDepartmentById(Long deptId) {
		deptRepo.deleteById(deptId);
	}

	@Override
	public Department updatDepartment(Long deptId, Department dept) {
		Department departFromDB = deptRepo.findById(deptId).get();
		
		if(Objects.nonNull(dept.getDepartmentName()) && 
				!"".equalsIgnoreCase(dept.getDepartmentName())) {
			departFromDB.setDepartmentName(dept.getDepartmentName());
		}
		
		if(Objects.nonNull(dept.getDepartmentCode()) && 
				!"".equalsIgnoreCase(dept.getDepartmentCode())) {
			departFromDB.setDepartmentCode(dept.getDepartmentCode());
		}
		
		if(Objects.nonNull(dept.getDepartmentAddress()) && 
				!"".equalsIgnoreCase(dept.getDepartmentAddress())) {
			departFromDB.setDepartmentAddress(dept.getDepartmentAddress());
		}
		
		return deptRepo.save(departFromDB);
	}

	@Override
	public Department fetchDepartmentByName(String deptName) {
		return deptRepo.findByDepartmentNameIgnoreCase(deptName);
	}
}
