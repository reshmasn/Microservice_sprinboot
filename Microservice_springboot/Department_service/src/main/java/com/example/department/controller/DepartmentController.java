package com.example.department.controller;

import com.example.department.entity.Department;
import com.example.department.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    DepartmentService departmentService;

    @PostMapping("/add")
    public Department saveDepartment(@RequestBody Department department){
        log.info("Inside saveDepartment method of DepartmentController");
        return departmentService.saveDepartment(department);
    }

//    @GetMapping("/{id}")
//    public Department findDepartmentById(@PathVariable("id") Long departmentId){
//       log.info("Inside findDepartmentById method of DepartmentController");
//       return departmentService.findDepartmentById(departmentId);
//    }

    @GetMapping("/get")
    public List<Department> findAll(){
        log.info("Inside findAll method of DepartmentController");
        return departmentService.findAll();
    }

    @GetMapping("/{id}")
    public Department findByDepartmentId(@PathVariable("id") Long departmentId){
        log.info("Inside findByDepartmentId method of DepartmentController");
        return departmentService.findByDepartmentId(departmentId);
    }


}


