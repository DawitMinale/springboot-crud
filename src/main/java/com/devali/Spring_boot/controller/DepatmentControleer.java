package com.devali.Spring_boot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.devali.Spring_boot.entity.Department;
import com.devali.Spring_boot.service.DepartmentService;

@RestController
public class DepatmentControleer {

    @Autowired
    private DepartmentService departmentService;


    // private final Logger=LoggerFactory.getLogger(DepatmentControleer.class)

    @PostMapping("/departments")
    public Department saveDepartment(@RequestBody Department department) {

        return departmentService.saveDepartment(department);

    }

    @GetMapping("/departments")
    public List<Department> fetchDepartmentList() {

        return departmentService.fetchDepartmentList();

    }

    @GetMapping("/departments/{id}")
    public Department fetchDepartmentById(@PathVariable("id") Long departmentId) {
        return departmentService.fetchDepartmentById(departmentId);
    }

    @DeleteMapping("/departments/{id}")
    public String DeleteDepartmentById(@PathVariable("id") Long departmentId) {

        departmentService.deleteDepartmentById(departmentId);
        return "Department deleted successfully";

    }

    @PutMapping("/departments/{id}")

    public Department updateDepartmentById(@PathVariable("id") Long departmentId,@RequestBody Department department){

        return departmentService.updateDepartmentById(departmentId,department);

    }


    @GetMapping("/departments/name/{name}")
    public Department fetchDepartmentByName(@PathVariable("name") String departmentName){

        return departmentService.fetchDepartmentByName(departmentName);

    }





}
