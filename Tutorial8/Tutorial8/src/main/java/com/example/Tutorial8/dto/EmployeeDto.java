package com.example.Tutorial8.dto;


import lombok.Builder;
import lombok.Data;


import java.util.UUID;

@Data
@Builder
public class EmployeeDto {

    UUID id;

    String name;

    int age;
    
    String image;
}
