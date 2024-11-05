package com.example.Tutorial9.controller;

import com.example.Tutorial9.dto.CompanyDto;
import com.example.Tutorial9.model.Company;
import com.example.Tutorial9.model.Employee;
import com.example.Tutorial9.repository.CompanyRepository;
import com.example.Tutorial9.repository.EmployeeRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/company")
public class CompanyController {

    CompanyRepository companyRepository;

    EmployeeRepository employeeRepository;

    @Autowired
    public CompanyController(CompanyRepository companyRepository, EmployeeRepository employeeRepository) {
        this.companyRepository = companyRepository;
        this.employeeRepository = employeeRepository;
    }

    @GetMapping(value = "/{id}")
    public String getCompanyById(
            @PathVariable(value = "id") UUID id, Model model
    ){
        Company company = companyRepository.getById(id);
        List<Employee> employees = employeeRepository.findAll();
        model.addAttribute("employees", employees);
        model.addAttribute("company", company);
        return "company/companyDetail";
    }

    @GetMapping(value = "/list")
    public String getAllCompany(Model model){
        List<Company> companies = companyRepository.findAll();
        model.addAttribute("companies", companies);
        return "company/companyList";
    }

    @PostMapping(value = "/add")
    public String saveUpdate(
            @RequestParam(value = "id", required = false) UUID id, @Valid Company company, BindingResult result
    ) {
        if (result.hasErrors()) {
            if (id == null) {
                return "company/companyAdd";
            } else {
                return  "company/companyUpdate";
            }
        }

        company.setCompanyId(id);
        companyRepository.save(company);
        return "redirect:/company/list";
    }

    @PostMapping("/update/{id}")
    public String updateCompany(@PathVariable UUID id, @Valid @ModelAttribute CompanyDto companyDto, BindingResult result) throws Exception {
        if (result.hasErrors()) {
            return "company/companyUpdate";
        }

        Company company = companyRepository.findById(id)
                .orElseThrow(() -> new Exception("Company does not exist"));

        company.setName(companyDto.getName());
        company.setImage(companyDto.getImage());
        company.setAddress(companyDto.getAddress());

        companyRepository.save(company);
        return "redirect:/company/list";
    }

    @GetMapping("/delete/{id}")
    public String deleteCompany(@PathVariable UUID id) throws Exception {
        Company company = companyRepository.findById(id)
                .orElseThrow(() -> new Exception("Company does not exist"));

        companyRepository.delete(company);
        return "redirect:/company/list";
    }

    @GetMapping(path = "/add")
    public String showCompanyAdd(Model model){
        model.addAttribute("company", new Company());
        return "/company/companyAdd";
    }

    @GetMapping("/update/{id}")
    public String showCompanyUpdate(Model model, @PathVariable UUID id) throws Exception {
        Company company = companyRepository.findById(id)
                .orElseThrow(() -> new Exception("Employee does not exist"));
        model.addAttribute("company", company);
        return "company/companyUpdate";
    }
}
