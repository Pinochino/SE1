package com.example.Tutorial9.controller;

import com.example.Tutorial9.model.Company;
import com.example.Tutorial9.model.Employee;
import com.example.Tutorial9.repository.CompanyRepository;
import com.example.Tutorial9.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping(path = "/employee")
public class EmployeeController {
    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    CompanyRepository companyRepository;

    @RequestMapping(value = "/add")
    public String addEmployee(Model model){
        Employee employee = new Employee();
        List<Company> companies = companyRepository.findAll();
        model.addAttribute("employee", employee);
        model.addAttribute("companies", companies);
        return "employeeAdd";
    }

    @RequestMapping("/search")
    public String searchEmployee(
            Model model,
            @RequestParam(value = "name") String name
    ){
        List<Employee> employees = employeeRepository.findByNameContaining(name);
        model.addAttribute("employees", employees);
        return "employeeList";
    }

    @RequestMapping("/sort/asc")
    public String sortEmployeeAsc(Model model){
        List<Employee> employees = employeeRepository.findAll(Sort.by(Sort.Direction.ASC, "name"));
        model.addAttribute("employees", employees);
        return "employeeList";
    }
}
