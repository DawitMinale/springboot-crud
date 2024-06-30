package com.devali.Spring_boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devali.Spring_boot.entity.Department;
import com.devali.Spring_boot.repository.DepartmentRepository;

import jakarta.validation.Valid;

@Service 
public class DepartmentServiceImpl implements  DepartmentService{

    
    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public Department saveDepartment(@Valid Department department) {
        return departmentRepository.save(department);

    }

    @Override
    public List<Department> fetchDepartmentList() {
        return departmentRepository.findAll();
    }

    @Override
    public Department fetchDepartmentById(Long departmentId) {
        return departmentRepository.findById(departmentId).get();
    }

    @Override
    public void deleteDepartmentById(Long departmentId) {
        departmentRepository.deleteById(departmentId);
    }

    @Override
    public Department updateDepartmentById(Long departmentId, Department department) {
        Department depDB=departmentRepository.findById(departmentId).get();
        if(department.getDepartmentName()!=null) {
            depDB.setDepartmentName(department.getDepartmentName());
        }
        if(department.getDepartmentAddress()!=null) {
            depDB.setDepartmentAddress(department.getDepartmentAddress());
        }
        if(department.getDepartmentCode()!=null) {
            depDB.setDepartmentCode(department.getDepartmentCode());
        }
        return departmentRepository.save(depDB);
    }

    @Override
    public Department fetchDepartmentByName(String departmentName) {

        return departmentRepository.findByDepartmentNameIgnoreCase(departmentName);
    }

}
