package com.devali.Spring_boot.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.devali.Spring_boot.entity.Department;
import com.devali.Spring_boot.repository.DepartmentRepository;

public class DepartmentServiceTest {


    @Autowired
    private DepartmentService departmentService;

    @MockBean
    private DepartmentRepository departmentRepository;



    @BeforeEach
    void setUp(){

        Department department=Department.builder()
                .departmentName("It")
                .departmentAddress("Pune")
                .departmentCode("IT-06")
                .departmentId(1L)
                .build();

Mockito.when(departmentRepository.findByDepartmentNameIgnoreCase("It")).thenReturn(department);
    }


    
    @Test
    public void whenValidDepartmentName_thenDepartmentShouldFound(){

        String departmentName="It";
        Department found=departmentService.fetchDepartmentByName(departmentName);

        assertEquals(found.getDepartmentName(),departmentName);


    }
}
