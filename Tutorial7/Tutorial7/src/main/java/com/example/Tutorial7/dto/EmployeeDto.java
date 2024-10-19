package com.example.Tutorial7.dto;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class EmployeeDto {

    UUID Id;

    String name;

    int age;

    String image;

    String address;
}
