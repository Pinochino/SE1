package com.example.Tutorial9.controller;

import com.example.Tutorial9.model.Company;
import com.example.Tutorial9.model.Employee;
import com.example.Tutorial9.repository.CompanyRepository;
import com.example.Tutorial9.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    CompanyRepository companyRepository;

    @Autowired
    EmployeeRepository employeeRepository;

    @RequestMapping(value = "/{id}")
    public String getCompanyById(
            @PathVariable(value = "id") UUID id, Model model
    ){
        Company company = companyRepository.getById(id);
        List<Employee> employees = employeeRepository.findAll();
        model.addAttribute("employees", employees);
        model.addAttribute("company", company);
        return "companyDetail";

    }
}
