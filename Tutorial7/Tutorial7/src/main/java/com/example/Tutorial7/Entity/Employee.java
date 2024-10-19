package com.example.Tutorial7.Entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.UUID;

@Entity
@Data
@Table(name = "Employee")
@FieldDefaults(level = AccessLevel.PUBLIC)
@Builder
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
            @Column(name = "id")
    UUID Id;

    @Column(name = "name")
    String name;

    @Column(name = "age")
    int age;

    @Column(name = "image")
    String image;

    @Column(name = "address")
    String address;

    public Employee() {
    }

    public Employee(UUID id, String name, int age, String image, String address) {
        Id = id;
        this.name = name;
        this.age = age;
        this.image = image;
        this.address = address;
    }
}
