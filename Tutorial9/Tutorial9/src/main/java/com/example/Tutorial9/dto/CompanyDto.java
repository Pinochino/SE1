package com.example.Tutorial9.dto;

import com.example.Tutorial9.model.Employee;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.hibernate.validator.constraints.Length;

import java.util.List;
import java.util.UUID;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CompanyDto {

    UUID companyId;

    String name;

    String image;

    String address;

}
