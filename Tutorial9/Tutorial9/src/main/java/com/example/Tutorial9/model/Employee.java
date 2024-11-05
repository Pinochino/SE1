package com.example.Tutorial9.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.sql.Blob;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "Employee")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@NoArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    UUID employeeId;

    @Column(name = "employeeName")
    String name;

    @Column(name = "age")
    Integer age;

    @Column(name = "dob")
    Date dob;

    @Column(name = "image")
    @NotEmpty(message = "Image can not be empty")
    String image;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "companyId")
    Company company;

}
