package com.example.Tutorial9.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.hibernate.validator.constraints.Length;

import java.util.UUID;

@Entity
@Table(name = "Company")
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "companyId", nullable = false)
    UUID companyId;

    @Size(min = 3, max = 30)
    String name;

    @NotEmpty
    String image;

    @Length(min = 5, max = 50)
    String address;

    @ManyToMany(cascade = CascadeType.ALL)
    Employee employee;
}
