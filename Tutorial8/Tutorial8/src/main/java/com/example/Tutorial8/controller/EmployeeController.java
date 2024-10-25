package com.example.Tutorial8.controller;

import com.example.Tutorial8.model.Employee;
import com.example.Tutorial8.repository.EmployeeRepository;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.UUID;

@Controller
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequestMapping(path = "/api")
public class EmployeeController {
    EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @GetMapping(value = "/list")
    public String getAllEmployee(Model model){
        return "employeeList";
    }

    @GetMapping(path = "/save")
    public String saveUpdate(
            @RequestParam(value = "id", required = false) UUID id, @Valid Employee employee, BindingResult result
            ){
        if (result.hasErrors()) {
            if( id == null){
                return "employeeAdd";
            } else {
                return "employeeUpdate";
            }
        }
        employee.setId(id);
        employeeRepository.save(employee);
        return "redirect:/list";

    }
}
