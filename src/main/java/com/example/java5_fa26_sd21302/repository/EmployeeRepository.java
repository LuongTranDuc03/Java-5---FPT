package com.example.java5_fa26_sd21302.repository;

import com.example.java5_fa26_sd21302.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
