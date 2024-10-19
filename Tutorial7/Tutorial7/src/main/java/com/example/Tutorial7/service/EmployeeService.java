package com.example.Tutorial7.service;

import com.example.Tutorial7.Entity.Employee;
import com.example.Tutorial7.dto.EmployeeDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public interface EmployeeService {

    List<Employee> getAllEmployee();

    Optional<Employee> findEmployeeById(UUID id);

    ResponseEntity<?> createEmployment(EmployeeDto employeeDto);

    ResponseEntity<?> update(EmployeeDto employeeDto, UUID id);

    void deleteEmployeeById(UUID id);

}
