package com.example.Tutorial8.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.validator.constraints.Length;

import java.util.UUID;

@Entity
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "Employee")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    UUID id;

    @Length(min = 3, max = 30)
    String name;

    @Min(18)
    @Max(55)
    int age;

    @Column(name = "Address")
    String address;

    @NotEmpty(message = "Image can not be empty")
    String image;

}
