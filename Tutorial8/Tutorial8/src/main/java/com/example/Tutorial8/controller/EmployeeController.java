package com.example.Tutorial8.controller;

import com.example.Tutorial8.dto.EmployeeDto;
import com.example.Tutorial8.model.Employee;
import com.example.Tutorial8.repository.EmployeeRepository;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
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
        return "employeeList";
    }

    @GetMapping("/employee/{id}")
    public String getEmployeeDetail(@PathVariable UUID id, Model model) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);

        if (optionalEmployee.isPresent()) {

            Employee employee = optionalEmployee.get();
            model.addAttribute("employee", employee);
        } else {
            return "redirect:/error";
        }

        return "employeeDetail";
    }

    @GetMapping("/add")
    public String showAddEmployeeForm(Model model) {
        model.addAttribute("employee", new Employee());
        return "employeeAdd";
    }

    @GetMapping("/update/{id}")
    public String showUpdateEmployeeForm(@PathVariable UUID id, Model model) throws Exception {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new Exception("Employee does not exist"));
        model.addAttribute("employee", employee);
        return "employeeUpdate";
    }


    @PostMapping(path = "/add")
    public String saveUpdate(
            @RequestParam(value = "id", required = false) UUID id, @Valid Employee employee, BindingResult result) {
        if (result.hasErrors()) {
            if (id == null) {
                return "employeeAdd";
            } else {
                return "employeeUpdate";
            }
        }
        employee.setId(id);
        employeeRepository.save(employee);
        return "redirect:/api/list";
    }

    @PostMapping("/update/{id}")
    public String updateEmployee(@PathVariable UUID id, @Valid @ModelAttribute EmployeeDto employeeDto, BindingResult result) throws Exception {
        if (result.hasErrors()) {
            return "employeeUpdate";
        }
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new Exception("Employee does not exist"));
        employee.setName(employeeDto.getName());
        employee.setAge(employeeDto.getAge());
        employee.setImage(employeeDto.getImage());
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
}
