package com.example.Tutorial9.controller;

import com.example.Tutorial9.dto.EmployeeDto;
import com.example.Tutorial9.model.Employee;
import com.example.Tutorial9.repository.EmployeeRepository;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
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

    @GetMapping(path = "/home")
    public String homepage(Model model) {
        return "_layout";
    }

    @GetMapping(value = "/list")
    public String getAllEmployee(Model model) {
        List<Employee> employeeList = employeeRepository.findAll();
        model.addAttribute("employees", employeeList);
        return "employee/employeeList";
    }

    @GetMapping(value = "/employee/{id}")
    public String getEmployeeById(
            @PathVariable(value = "id") UUID id, Model model) {
        Optional<Employee> employeeOptional = employeeRepository.findById(id);

        model.addAttribute("employee", employeeOptional);
        return "employee/employeeDetail";
    }

    @GetMapping("/add")
    public String showAddEmployeeForm(Model model) {
        model.addAttribute("employee", new Employee());
        return "employee/employeeAdd";
    }

    @GetMapping("/update/{id}")
    public String showUpdateEmployeeForm(@PathVariable UUID id, Model model) throws Exception {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new Exception("Employee does not exist"));
        model.addAttribute("employee", employee);
        return "employee/employeeUpdate";
    }

    @PostMapping(path = "/add")
    public String saveUpdate(
            @RequestParam(value = "id", required = false) UUID id, @Valid Employee employee, BindingResult result) {
        if (result.hasErrors()) {
            if (id == null) {
                return "employee/employeeAdd";
            } else {
                return "employee/employeeUpdate";
            }
        }
        employee.setId(UUID.randomUUID());
        employeeRepository.save(employee);
        return "redirect:/api/list";
    }

    @PostMapping("/update/{id}")
    public String updateEmployee(@PathVariable UUID id, @Valid @ModelAttribute EmployeeDto employeeDto,
            BindingResult result) throws Exception {
        if (result.hasErrors()) {
            return "employee/employeeUpdate";
        }
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new Exception("Employee does not exist"));
        employee.setName(employeeDto.getName());
        employee.setAge(employeeDto.getAge());
        employee.setDob(employeeDto.getDob());
        employeeRepository.save(employee);
        return "redirect:/api/list";
    }

    @GetMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable UUID id) throws Exception {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new Exception("Employee does not exist"));
        employeeRepository.delete(employee);
        return "redirect:/api/list";
    }

    @GetMapping("/search")
    public String searchEmployee(Model model,
            @RequestParam(value = "name") String name) {
        List<Employee> employees = employeeRepository.findByNameContaining(name);
        model.addAttribute("employees", employees);
        return "employee/employeeList";
    }

    @GetMapping("/sort/asc")
    public String sortEmployeeAsc(Model model) {
        List<Employee> employees = employeeRepository.findAll(Sort.by(Sort.Direction.ASC, "name"));
        model.addAttribute("employees", employees);
        return "employee/employeeList";
    }

    @GetMapping("/sort/desc")
    public String sortEmployeeDesc(Model model) {
        List<Employee> employees = employeeRepository.findAll(Sort.by(Sort.Direction.DESC, "name"));
        model.addAttribute("employees", employees);
        return "employee/employeeList";
    }

}
