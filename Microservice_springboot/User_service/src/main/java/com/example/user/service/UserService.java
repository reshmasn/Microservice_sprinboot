package com.example.user.service;


import com.example.user.VO.Department;
import com.example.user.VO.ResponseTemplateVO;
import com.example.user.entity.User;
import com.example.user.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@Slf4j
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RestTemplate restTemplate;

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public List<User> findAll() {
        return  userRepository.findAll();
    }

    public ResponseTemplateVO getUserWithDepartment(Long userId) {
        ResponseTemplateVO vo = new ResponseTemplateVO();
        User user = userRepository.findByUserId(userId);
        log.info("Inside the UserService got the user object");
        Department department = restTemplate.getForObject("http://DEPARTMENT-SERVICE/department/" + user.getDepartmentId(), Department.class);
        log.info("Inside the UserService got the department object");
        vo.setUser(user);
        vo.setDepartment(department);
        return vo;
    }

    public ResponseEntity<Department> saveDepartmentByUser(Department department) {
        HttpHeaders httpHeaders=new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Department> httpEntity=new HttpEntity(department,httpHeaders);
        return restTemplate.exchange("http://DEPARTMENT-SERVICE/department/add", HttpMethod.POST,httpEntity, Department.class);
    }
}
