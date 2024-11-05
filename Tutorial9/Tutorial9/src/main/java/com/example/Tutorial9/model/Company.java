package com.example.Tutorial9.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.validator.constraints.Length;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "Company")
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
@AllArgsConstructor
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

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "company", fetch = FetchType.LAZY)
    List<Employee> employeeList;
}
