package com.example.Tutorial7.service;

import com.example.Tutorial7.Entity.Employee;
import com.example.Tutorial7.dto.EmployeeDto;
import com.example.Tutorial7.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EmployeeServiceImpl implements  EmployeeService{

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }

    @Override
    public Optional<Employee> findEmployeeById(UUID id) {
        return employeeRepository.findById(id);
    }

    @Override
    public ResponseEntity<?> createEmployment(EmployeeDto employeeDto) {
        if (employeeRepository.findById(employeeDto.getId()).isPresent()){
            return ResponseEntity.badRequest().body("Employee have already exist");
        }

       Employee employee = Employee.builder()
               .name(employeeDto.getName())
               .address(employeeDto.getAddress())
               .image(employeeDto.getImage())
               .age(employeeDto.getAge())
               .build();
        employeeRepository.save(employee);
        return ResponseEntity.ok(employee);
    }

    @Override
    public ResponseEntity<?> update(EmployeeDto employeeDto, UUID id) {
        Optional<Employee> employeeOptional = employeeRepository.findById(id);

        if (employeeRepository.findById(employeeDto.getId()).isPresent()){
            return ResponseEntity.badRequest().body("Employee have already exist");
        }

       Employee employee = employeeOptional.get();
        employee.setName(employeeDto.getName());
        employee.setAge(employee.getAge());
        employee.setImage(employee.getImage());

        employeeRepository.save(employee);
        return ResponseEntity.ok("Employee updated successfully");
    }

    @Override
    public void deleteEmployeeById(UUID id) {
        employeeRepository.deleteById(id);
    }
}
