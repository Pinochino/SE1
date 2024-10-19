package com.example.Tutorial7.controller;

import com.example.Tutorial7.Entity.Employee;
import com.example.Tutorial7.dto.EmployeeDto;
import com.example.Tutorial7.repository.EmployeeRepository;
import com.example.Tutorial7.service.EmployeeService;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Controller
@RequestMapping(path = "/api")
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EmployeeController {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    EmployeeService employeeService;

    @RequestMapping(value = "/employeeList")
    public String getAllEmployee(Model model){
        List<Employee> employeeList = employeeRepository.findAll();
        model.addAttribute("employees", employeeList);
        return "employeeList";
    }

    @RequestMapping(value = "/{id}")
    public String getEmployeeById(
            @PathVariable(value = "id") UUID id, Model model
            ){
        Employee employeeOptional = employeeRepository.getById(id);

        model.addAttribute("employee", employeeOptional);
        return "employeeDetail";
    }

    @GetMapping(path = "/createEmployee")
    public ResponseEntity<?> createEmployee(){
        EmployeeDto employeeDto = EmployeeDto.builder()
                .Id(UUID.randomUUID())
                .name("Linh")
                .image("https://avatars.githubusercontent.com/u/139600392?v=4")
                .age(20)
                .address("Ha Noi")
                .build();
        ResponseEntity<?> employee = employeeService.createEmployment(employeeDto);
        return employee;
    }

}
