package com.example.Tutorial9.dto;

import com.example.Tutorial9.model.Company;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployeeDto {

    UUID employeeId;

    String name;

    Integer age;

    Date dob;

    Company company;
}
