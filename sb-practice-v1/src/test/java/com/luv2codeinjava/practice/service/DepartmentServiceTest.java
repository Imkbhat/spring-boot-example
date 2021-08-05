package com.luv2codeinjava.practice.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.luv2codeinjava.practice.entity.Department;
import com.luv2codeinjava.practice.repository.DepartmentRepository;
import com.luv2codeinjava.practice.service.DepartmentService;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class DepartmentServiceTest {

    @Autowired
    private DepartmentService departmentService;

    @MockBean
    private DepartmentRepository departmentRepository;

    @BeforeEach
    void setUp() {
        Department department =
                Department.builder()
                .departmentName("CS")
                .departmentAddress("Bengaluru")
                .departmentCode("CS-06")
                .departmentId(1L)
                .build();

        Mockito.when(departmentRepository.findByDepartmentNameIgnoreCase("CS"))
                .thenReturn(department);

    }

    @Test
    @DisplayName("Get Data based on Valida Department Name")
    public void whenValidDepartmentName_thenDepartmentShouldFound() {
        String departmentName = "CS";
        Department found =
                departmentService.fetchDepartmentByName(departmentName);

        assertEquals(departmentName, found.getDepartmentName());
    }
}