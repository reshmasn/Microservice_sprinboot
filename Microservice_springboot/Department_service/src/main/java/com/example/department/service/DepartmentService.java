package com.example.department.service;

import com.example.department.entity.Department;
import com.example.department.repository.DepartmentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class DepartmentService {

    @Autowired
    DepartmentRepository departmentRepository;


    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

   public Department findByDepartmentId(Long departmentId) {
       log.info("Inside findByDepartmentId method of DepartmentService");
     return departmentRepository.findByDepartmentId(departmentId);
  }

    public List<Department> findAll() {
        return departmentRepository.findAll();
    }

}
