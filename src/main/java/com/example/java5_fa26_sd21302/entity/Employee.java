package com.example.java5_fa26_sd21302.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "employees")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Tên nhân viên không được để trống")
    @Size(min = 2, max = 50, message = "Tên nhân viên phải từ 2 đến 50 ký tự")
    @Column(columnDefinition = "nvarchar(100)", nullable = false)
    private String name;

    @NotBlank(message = "Email không được để trống")
    @Email(message = "Email không đúng định dạng")
    @Column(nullable = false)
    private String email;

    @NotNull(message = "Lương không được để trống")
    @Positive(message = "Lương phải lớn hơn 0")
    @Column(nullable = false)
    private Double sallary;

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", sallary=" + sallary +
                '}';
    }
}
